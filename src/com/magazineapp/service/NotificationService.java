package com.magazineapp.service;

import com.magazineapp.model.Faculty;
import com.magazineapp.model.Submission;
import com.magazineapp.model.User;
import com.magazineapp.repository.UserRepo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationService
{
    private static final String SMTP_HOST  = "smtp.mail.yahoo.com";
    private static final String SMTP_EMAIL = "ewd.system@yahoo.com";
    private static final String SMTP_PASS  = "123@123a";
    
    private Submission submission;
    private User coordinator;

    public NotificationService(Submission submission)
    {
        this.submission = submission;
        Faculty submissionFaculty = submission.get_author().get_faculty();
        coordinator = new UserRepo().getCoordinatorOf(submissionFaculty);
    }

    public void sendEmail()
    {
        String to = "ewd.coordinator@sharklasers.com";

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

        Session session = Session.getDefaultInstance(props, auth);
        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTP_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("New Magazine submission");
            message.setText("test body");

            Transport.send(message);

            System.out.println("Sent message successfully....");
        } catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
