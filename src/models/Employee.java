package models;


import java.io.Serializable;
import java.util.HashMap;

public class Employee extends Account implements Serializable {
    public Employee(String userName, String password, String name, boolean isAdmin) {
        super(userName, password, name, isAdmin);
        super.setDailyProtocols(new HashMap<>());
    }
}
