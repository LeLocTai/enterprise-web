package com.magazineapp.model;

import java.util.ArrayList;

public class Faculty {
    private int _id;
    private String _name;
    private ArrayList<User> _users = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(int _id, String _name, ArrayList<User> _users) {
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

    public ArrayList<User> get_users() {
        return _users;
    }

    public void set_users(ArrayList<User> _users) {
        this._users = _users;
    }
}