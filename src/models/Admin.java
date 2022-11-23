package models;

import java.io.Serializable;

public class Admin extends Account implements Serializable {
    public Admin(String userName, String password, boolean isAdmin) {
        super(userName, password, isAdmin);
    }
}
