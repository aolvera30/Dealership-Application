package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager
{

    public Dealership loadDearlership()
    {
        Dealership dealership = null;

        // Read data from the inventory CSV file
        try(Scanner fileScanner = new Scanner(new File("inventory.csv"))) {
            String dealerLine = fileScanner.nextLine(); // this is the dealership  name, address and phone
            String[] parts = dealerLine.split("\\|");
            dealership = new Dealership(parts[0], parts[1], parts[2]);

            // Read each line of the file and parse vehicle data
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] tokens = line.split("\\|");

                // Extract vehicle data from tokens
                int vin = Integer.parseInt(tokens[0].trim());
                int year = Integer.parseInt(tokens[1].trim());
                String make = tokens[2].trim();
                String model = tokens[3].trim();
                String vehicleType = tokens[4].trim();
                String color = tokens[5].trim();
                int odometer = Integer.parseInt(tokens[6].trim());
                double price = Double.parseDouble(tokens[7].trim());

                // Create a Vehicle object with extracted data and add it to the inventory
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            throw new RuntimeException("Failed to load inventory: File not found.", e);
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {}




}
