package services;

import java.util.Scanner;

public class PressEnter {
    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

}
