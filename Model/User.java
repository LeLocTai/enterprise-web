import java.util.ArrayList;

public class User {
	private int _id;
	private String _role;
	private boolean _has_Accepted_TOC;
	private String _email;
	public Faculty _faculty;
	public ArrayList<Submission> _submissions = new ArrayList<Submission>();

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_role() {
		return _role;
	}

	public void set_role(String _role) {
		this._role = _role;
	}

	public boolean is_has_Accepted_TOC() {
		return _has_Accepted_TOC;
	}

	public void set_has_Accepted_TOC(boolean _has_Accepted_TOC) {
		this._has_Accepted_TOC = _has_Accepted_TOC;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public Faculty get_faculty() {
		return _faculty;
	}

	public void set_faculty(Faculty _faculty) {
		this._faculty = _faculty;
	}

	public ArrayList<Submission> get_submissions() {
		return _submissions;
	}

	public void set_submissions(ArrayList<Submission> _submissions) {
		this._submissions = _submissions;
	}

	public User(int _id, String _role, boolean _has_Accepted_TOC, String _email, Faculty _faculty, ArrayList<Submission> _submissions) {
		this._id = _id;
		this._role = _role;
		this._has_Accepted_TOC = _has_Accepted_TOC;
		this._email = _email;
		this._faculty = _faculty;
		this._submissions = _submissions;
	}

	public User() {
	}
}