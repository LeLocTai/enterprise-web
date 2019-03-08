import java.util.Vector;

public class Faculties {
	private int _id;
	private String _name;
	public Vector<Users> _users = new Vector<Users>();

	public Faculties() {
	}

	public Faculties(int _id, String _name, Vector<Users> _users) {
		this._id = _id;
		this._name = _name;
		this._users = _users;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Vector<Users> get_users() {
		return _users;
	}

	public void set_users(Vector<Users> _users) {
		this._users = _users;
	}
}