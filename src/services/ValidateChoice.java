package services;

public class ValidateChoice {
    private static int ifDigitInRange(int choice, int endOfRange) {
        int result = choice;
        if (choice < 0 || choice > endOfRange) {//is OUT of range
            System.out.println(choice + " is out of range.\nYour choice must be between 0 and " + endOfRange);
            result = -1;
        }
        return result;
    }

    private static boolean ifDigit(String choice, int endOfRange) {
        boolean ifDigit = false;
        try {
            Integer.parseInt(choice);
            ifDigit = true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter digit from 0 to " + endOfRange + " including!");
        }
        return ifDigit;
    }

    public static int validateChoice(String inputChoice, int endOfRange) {
        int result = -1;//choice value OUT of range
        if (ifDigit(inputChoice, endOfRange)) {//is a digit
            if (ifDigitInRange(Integer.parseInt(inputChoice), endOfRange) != -1) {
                result = Integer.parseInt(inputChoice);
            }
        }
        return result;
    }
}