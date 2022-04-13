package carsharing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length > 0) {
            DatabaseService.DB_URI += args[1];
        } else {
            DatabaseService.DB_URI += "carsharing";
        }

        DatabaseService.createTables();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            printStartingMenu();
            int selection = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (selection) {

                case 1:
                    new Manager().start();
                    break;

                case 2:
                    new Customer().start();
                    break;

                case 3:
                    System.out.println("Enter the customer name:");
                    String customerName = scanner.nextLine();
                    DatabaseService.createANewCustomer(customerName);
                    break;

                case 0:
                    return;
            }
        }
    }

    static void printStartingMenu() {

        System.out.println("1. Log in as a manager\n" +
                        "2. Log in as a customer\n" +
                        "3. Create a customer\n" +
                        "0. Exit"
        );
    }
}