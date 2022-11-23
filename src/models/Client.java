package models;

import menus.Login;
import services.Load;
import services.PressEnter;
import services.Save;
import services.Validators;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Serializable {
    private String clientName;
    private String projectName;
    private String expirationDate;

    public Client(String clientName, String projectName, String expirationDate) {
        this.clientName = clientName;
        this.projectName = projectName;
        this.expirationDate = expirationDate;
    }

    public String getClientName() {
        return clientName;
    }


    public String getProjectName() {
        return projectName;
    }


    public String getExpirationDate() {
        return expirationDate;
    }

    public static int getChosenClientIndex() {

        System.out.print("Choose ID number of a Client - > ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Client> clientsList = Load.clientListFromFile();
        int choice = Validators.validateChoice(sc.nextLine(), clientsList.size());
        if (choice == -1) {
            getChosenClientIndex();
        }
        return choice - 1;

    }
}

