package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidateIfFileIsEmpty {
    public static boolean ifFileIsEmpty(String filePath) {
        boolean isEmpty = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            if (br.readLine() != null) {
                isEmpty = false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File NOT found");
        } catch (IOException e) {
            System.out.println("Unable to read Clients.txt List");
        }
        return isEmpty;
    }
}
