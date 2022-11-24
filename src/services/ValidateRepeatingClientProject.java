package services;

import models.Client;

import java.util.ArrayList;

public class ValidateRepeatingClientProject {
    public static boolean checkRepeatingClientProject(String clientName, String projectName) {
        ArrayList<Client> clientsList = Load.clientListFromFile();
        boolean exists = false;
        for (Client client : clientsList) {
            if (clientName.equalsIgnoreCase(client.getClientName()) && projectName.equalsIgnoreCase(client.getProjectName())) {
                exists = true;
            }
        }
        return exists;
    }
}
