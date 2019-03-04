import java.util.Vector;

public class Users {
	private int _id;
	private String _role;
	private boolean _has_Accepted_TOC;
	private String _email;
	public Faculties _faculty;
	public Vector<Submissions> _submissions = new Vector<Submissions>();
}