package carsharing;

import java.util.Scanner;

public class CustomerAccount {

    int id;
    String name;
    int rentedCarId;

    public CustomerAccount(int id, String name, int rentedCarId) {
        this.id = id;
        this.name = name;
        this.rentedCarId = rentedCarId;
    }

    public CustomerAccount(CustomerAccount customerAccount) {
        this.id = customerAccount.id;
        this.name = customerAccount.name;
        this.rentedCarId = customerAccount.rentedCarId;
    }

    void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            int selection = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (selection) {

                case 1:
                    DatabaseService.rentACar(this);
                    break;

                case 2:
                    DatabaseService.returnCar(this);
                    break;

                case 3:
                    DatabaseService.getCustomerRentedCar(this);
                    break;

                case 0:
                    return;
            }

        }
    }

    private void printMenu() {

        System.out.println("1. Rent a car\n" +
                "2. Return a rented car\n" +
                "3. My rented car\n" +
                "0. Back");
    }
}
