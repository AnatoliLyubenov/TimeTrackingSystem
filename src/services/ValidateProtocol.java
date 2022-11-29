package services;

import models.Client;
import models.Protocol;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidateProtocol {
    public static int checkIfProjectRecordExists(ArrayList<Client> clientsList, ArrayList<Protocol> todayProtocols, int clientIndex) {
        int exists = -1;//if it doesn't exist
        for (int i = 0; i < todayProtocols.size(); i++) {
            if (todayProtocols.get(i).getClient().getProjectName().equals(clientsList.get(clientIndex).getProjectName())) {//if DailyProtocol list contains Client with the same project name
                exists = i;//if exists return index of the protocol record
                break;
            }
        }
        return exists;
    }

    public static boolean checkIfDailyProtocolExists(String protocolDate, HashMap<String, ArrayList<Protocol>> employeeDailyProtocols) {
        boolean isProtocolPresent = false;
        if (employeeDailyProtocols.containsKey(protocolDate)) {
            isProtocolPresent = true;
        }
        return isProtocolPresent;
    }
}
