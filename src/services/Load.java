package services;

import models.Account;
import models.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static services.ValidateIfFileIsEmpty.ifFileIsEmpty;

public class Load {
    public static ArrayList<Client> clientListFromFile() {
        ArrayList<Client> clientsList;
        if (ifFileIsEmpty("ProgramFiles/ClientsList.txt")) {
            clientsList = new ArrayList<Client>();
        } else {
            try {
                ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ProgramFiles/ClientsList.txt"));
                clientsList = (ArrayList<Client>) reader.readObject();
                reader.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Class Not Found!");
            }
        }

        return clientsList;
    }

    public static HashMap<String, Account> accountsListFromFile() {
        HashMap<String, Account> accountsList;
        if (ifFileIsEmpty("ProgramFiles/AccountsList.txt")) {
            accountsList = new HashMap<String, Account>();
        } else {
            try {
                FileInputStream fi = new FileInputStream("ProgramFiles/AccountsList.txt");
                ObjectInputStream reader = new ObjectInputStream(fi);
                accountsList = (HashMap<String, Account>) reader.readObject();
                reader.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Class Not Found!");
            }
        }
        return accountsList;
    }
}
