package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

abstract public class Account implements Serializable {

    private String userName;
    private String password;
    private String name;
    private boolean isAdmin;
    private HashMap<String, ArrayList<Protocol>> dailyProtocols;//String is Protocol's date "dd.MM.yyyy"

    public Account() {
    }


    public Account(String userName, String password,String name, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    public Account(String userName, String password, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public HashMap<String, ArrayList<Protocol>> getDailyProtocols() {
        return dailyProtocols;
    }

    public void setDailyProtocols(HashMap<String, ArrayList<Protocol>> dailyProtocols) {
        this.dailyProtocols = dailyProtocols;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
