package Order.impl;

import java.util.ArrayList;
import java.util.Scanner;

public class SantasLittleHelpers {


    public String selectItem(ArrayList<String> items) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Please select from the following options:\n ");

            for (int i = 0; i <= items.size(); i++) {
                sb.append("Press " + i + 1 + " for "items[i]".\n")
            }

            System.out.println(sb.toString());

            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            while (input < 0 || input > items.size()) {
                System.out.println("Invalid selection. Please choose an valid option");
                System.out.println();
                System.out.println(sb.toString());
                input = sc.nextInt();
            }
            return items.get(input - 1);
        } catch (Exception e) {
            System.out.println("Ooops. Something went wrong.");

        }

        return "-1";
    }

}
