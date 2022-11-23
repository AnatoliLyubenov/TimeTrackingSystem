package services;

import models.Client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load {
    public static ArrayList<Client> clientListFromFile() {
        ArrayList<Client> clientsList;
        if (Validators.ifFileIsEmpty("ProgramFiles/ClientsList.txt")){
            clientsList = new ArrayList<Client>();
        }else {
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

}
