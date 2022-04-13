package carsharing;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    void start() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<CustomerAccount> customers = DatabaseService.getCustomers();

        if (customers.size() == 0) {
            System.out.println("The customer list is empty!");
            System.out.println();
        } else {
            printCustomers(customers);

            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            if (choice == 0) {
                return;
            }

            CustomerAccount currentCustomer = new CustomerAccount(customers.get(choice - 1));
            currentCustomer.start();
        }
    }

    private void printCustomers(ArrayList<CustomerAccount> customers) {

        System.out.println("Customer list:");

        int id = 1;

        for (CustomerAccount customer : customers) {
            System.out.println(id + ". " + customer.name);
            id++;
        }
        System.out.println("0. Back");
    }
}
