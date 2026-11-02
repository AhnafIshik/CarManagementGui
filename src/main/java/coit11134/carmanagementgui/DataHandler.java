package coit11134.carmanagementgui;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandler {

    private String fileName;
    private ArrayList<Car> carList;

    public DataHandler(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.carList = new ArrayList<>();
        readDataFile();
    }

    private void readDataFile() {
        try (Scanner input = new Scanner(new FileReader(fileName))) {
            while (input.hasNextLine()) {
                String[] parts = input.nextLine().split(",");
                if (parts.length == 6) {
                    carList.add(new Car(
                        Integer.parseInt(parts[0]),
                        parts[1], parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        parts[5]
                    ));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. A new file will be created upon saving.");
        }
    }

    public void saveData() {
        try (PrintWriter output = new PrintWriter(fileName)) {
            for (Car c : carList) {
                output.println(c.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public boolean idExists(int id) {
        return carList.stream().anyMatch(c -> c.getCarID() == id);
    }

    public Car findCarByID(int id) {
        return carList.stream().filter(c -> c.getCarID() == id).findFirst().orElse(null);
    }

    public String getDisplayOutput() {
        if (carList.isEmpty()) return "No cars registered.";
        StringBuilder sb = new StringBuilder();
        for (Car c : carList) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }
}