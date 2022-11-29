package models;

import menus.Login;
import services.Load;
import services.PressEnter;
import services.ValidateIfFileIsEmpty;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static services.ValidateChoice.validateChoice;

public class Client implements Serializable {
    private String clientName;
    private String projectName;
    private String expirationDate;

    public Client(String clientName, String projectName, String expirationDate) {
        this.clientName = clientName;
        this.projectName = projectName;
        this.expirationDate = expirationDate;
    }

    public static int getChosenClientIndex() {
        int result = 0;
        ArrayList<Client> clientsList = Load.clientListFromFile();
        showClients();
        System.out.print("Choose ID number of a Client - > ");
        Scanner sc = new Scanner(System.in);
        int choice = validateChoice(sc.nextLine(), clientsList.size());
        if (choice == -1) {
            result=getChosenClientIndex();
        }else {
            result=choice;
        }
        return result - 1;
    }

    private static void showClients() {

        if (ValidateIfFileIsEmpty.ifFileIsEmpty("ProgramFiles/ClientsList.txt")) {
            System.out.println("List of Clients.txt is empty.");
            System.out.println("Register Clients.txt first.");
            PressEnter.promptEnterKey();
            Login.loginMenu();
        } else {
            ArrayList<Client> clientsList = Load.clientListFromFile();
            System.out.println("AvailableClients List:");
            System.out.println("================================================================");
            for (int i = 0; i < clientsList.size(); i++) {
                System.out.println("ID - > " + (i + 1));
                System.out.println("Client Name - > " + clientsList.get(i).getClientName());
                System.out.println("Project Name - > " + clientsList.get(i).getProjectName());
                System.out.println("Expiration Date - > " + clientsList.get(i).getExpirationDate());
                System.out.println("================================================================");
            }
        }
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
}