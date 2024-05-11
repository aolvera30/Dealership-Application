package com.pluralsight;

import java.util.Scanner;

public class UserInterface
{
    private Dealership dealership;

    public  UserInterface() {
        init();

    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.loadDearlership();

    }


    public void display() {
        init(); // Load the dealership data

        Scanner userInput = new Scanner(System.in);
        boolean running = true;
        while (running) {
            // Display menu options
            System.out.println("1. Get by Make and Model");
            System.out.println("2. Get by Year");
            System.out.println("3. Get by Color");
            System.out.println("4. Get by Mileage");
            System.out.println("5. Get by Vehicle Type");
            System.out.println("6. Get All Vehicles");
            System.out.println("7. Add Vehicle");
            System.out.println("8. Remove Vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read user input
            int choice = userInput.nextInt();
            userInput.nextLine();

            // Process user command
            switch (choice) {
                case 1:
                    processGetByMakeModelRequest();
                    break;
                case 2:
                    processGetByYearRequest();
                    break;
                case 3:
                    processGetByColorRequest();
                    break;
                case 4:
                    processGetByMileageRequest();
                    break;
                case 5:
                    processGetByVehicleTypeRequest();
                    break;
                case 6:
                    processGetAllVehiclesRequest();
                    break;
                case 7:
                    processAddVehicleRequest();
                    break;
                case 8:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        userInput.close();
    }


    public void processGetByMakeModelRequest() {}

    public void processGetByYearRequest() {}

    public void processGetByColorRequest() {}

    public void processGetByMileageRequest() {}

    public void processGetByVehicleTypeRequest() {}

    public void processGetAllVehiclesRequest() {}

    public void processAddVehicleRequest() {}

    public void processRemoveVehicleRequest() {}
}
