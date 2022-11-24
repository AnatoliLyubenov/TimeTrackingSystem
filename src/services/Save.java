package services;


import models.Account;
import models.Client;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Save {
    public static void accountsListToFile(HashMap<String, Account> accountsList, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);// "ProgramFiles/AccountsList.txt"
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(accountsList);
            objectOut.close();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
            // exception.printStackTrace();
        }
    }
    public static void clientListToFile(ArrayList<Client> clientsList, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);// "ProgramFiles/ClientsList.txt"
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(clientsList);
            objectOut.close();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
