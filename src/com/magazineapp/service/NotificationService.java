package com.magazineapp.service;

import com.magazineapp.model.Faculty;
import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.SubmissionRepo;
import com.magazineapp.repository.UserRepo;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class NotificationService
{
    private static final String SMTP_HOST  = "smtp.mail.yahoo.com";
    private static final String SMTP_EMAIL = "ewd.system@yahoo.com";
    private static final String SMTP_PASS  = "123@123a";

    private static final String EMAIl_TEMPLATE = "<p>New magazine submission received, please visit <a href='%1$s'>%1$s</a> to view</p>";

    private Submission submission;
    String coordinatorViewPath;
    private User coordinator;

    public NotificationService(Submission submission, HttpServletRequest context)
    {
        this.submission = submission;

        coordinator = new UserRepo().getCoordinatorOf(submission.get_author().get_faculty());
        coordinatorViewPath = String.format("http://%s:%d%s/Admin/viewAllSubmission.jsp",
                                            context.getServerName(),
                                            context.getServerPort(),
                                            context.getContextPath());
    }

    private InternetAddress getRecipient() throws AddressException
    {
        return new InternetAddress(coordinator.get_email()); //ewd.coordinator@sharklasers.com
    }

    private String getMessageBody()
    {
        return String.format(EMAIl_TEMPLATE, coordinatorViewPath);
    }

    public void scheduleEmail()
    {
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 587);

        Authenticator auth = new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(SMTP_EMAIL, SMTP_PASS);
            }
        };

        Session session = Session.getInstance(props, auth);
        
        new Thread(() -> sendEmail(session)).start();
    }

    private void sendEmail(Session session)
    {
        try
        {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(SMTP_EMAIL));
            message.addRecipient(Message.RecipientType.TO, getRecipient());
            message.setSubject("New magazine submission");
            message.setContent(getMessageBody(), "text/html");

            Transport.send(message);

            submission.set_has_Sent_Notice(true);
            new SubmissionRepo().update(submission);

            System.out.println("Sent message successfully....");
        } catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
