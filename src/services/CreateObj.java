package services;

import models.Account;
import models.Admin;

import java.util.HashMap;


    public class CreateObj {
        public static int adminObj(String accountName, String accountPassword, String filePath) {
            HashMap<String, Account> accountsList = new HashMap<>();
            accountsList.put(accountName, new Admin(accountName, accountPassword, true));
            Save.accountsListToFile(accountsList, filePath);
            return 1;

        }
    }



