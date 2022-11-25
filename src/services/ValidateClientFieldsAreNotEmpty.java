package services;

import java.util.HashMap;

public class ValidateClientFieldsAreNotEmpty {
    public static boolean validateEnterClientFieldsAreNotEmpty(String clientName,String projectName,String expirationDate) {
        boolean isNotEmpty = true;
        HashMap<String, String> fields = new HashMap<>();
        fields.put(clientName, "\"Client's Name\"");
        fields.put(projectName, "\"Project's Name\"");
        fields.put(expirationDate, "\"Expiration date\"");

        for (String field : fields.keySet()) {
            if (field.equals("")) {
                System.out.println("Empty fields are NOT acceptable!!!");
                System.out.println(fields.get(field) + " field can NOT be empty!");
                isNotEmpty = false;
            }
        }
        return isNotEmpty;
    }
}
