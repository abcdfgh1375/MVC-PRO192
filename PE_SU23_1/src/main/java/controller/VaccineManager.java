package controller;
import Model.Vaccine;
import View.Menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Inputter;
import utils.Validation;
//
//public class VaccineManager extends Menu{
//    List<Vaccine> vaccines ;
//    //static String fileName = "C:\\Users\\THANH HUYEN\\Documents\\NetBeansProjects\\PE_SU23_1\\vaccines_input.txt";
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//    public VaccineManager() {
//        super("Vaccin Management System", Arrays.asList(new String[]{"Display all vaccines from file","Add a Vaccine",
//        "Delete a Vaccine by code","Sort Vaccines by Name","Save to File","Exit"}));
//        vaccines = new ArrayList();
//    }
////    
//    public void loadVaccineFromFile(String fileName){
//        try {
//        BufferedReader br = new BufferedReader(new FileReader(fileName));
//        String line;
//        while ((line = br.readLine()) != null) {
//            String[] linearr = line.split(",");
//            vaccines.add(new Vaccine (linearr[0], linearr[1], Integer.parseInt(linearr[2]),dateFormat.parse(linearr[3]), Double.parseDouble(linearr[4]),dateFormat.parse(linearr[5])));
//        }
//        br.close();
//    } catch (FileNotFoundException ex) {
//        System.out.println("File not found " + fileName);
//    } catch (IOException ex) {
//        System.out.println("An error occurred while reading the file");
//    }catch (ParseException pe){
//        Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, pe);
//    }
//    }
//    
//   private void loadVaccinesFromFile(String filename) {
//        try {
//            Scanner sc = new Scanner(new File(filename));
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                String[] data = line.split(", ");
//                if (data.length == 6) {
//                    String code = data[0].split("=")[1];
//                    String name = data[1].split("=")[1];
//
//                    //kiểm tra định dạng quantity 
//                    String quantity_string = data[2].split("=")[1];
//                    boolean quantity_bool = Validation.isNumericInt(quantity_string);
//
//                    //kiểm tra định dạng expirationDate
//                    String expirationDate_string = data[3].split("=")[1];
//                    boolean expirationDate_bool = Validation.isValidDate(expirationDate_string, "dd/MM/yyyy");
//
//                    //kiểm tra định dạng price
//                    String price_string = data[4].split("=")[1];
//                    boolean price_bool = Validation.isNumericDouble(price_string);
//
//                    //kiểm tra định dạng lastInjectedDate
//                    String lastInjectedDate_string = data[5].split("=")[1];
//                    boolean lastInjectedDate_bool = Validation.isValidDate(lastInjectedDate_string, "dd/MM/yyyy");
//
//                    if (quantity_bool && price_bool && expirationDate_bool && lastInjectedDate_bool) {
//                        int quantity = Integer.parseInt(quantity_string);
//                        double price = Double.parseDouble(price_string);
//                        Date expirationDate = Validation.parseDate(expirationDate_string);
//                        Date lastInjectedDate = Validation.parseDate(lastInjectedDate_string);
//
//                        Vaccine vaccine = new Vaccine(code, name, quantity,
//                                expirationDate, price, lastInjectedDate);
//                        vaccines.add(vaccine);
//                    }
//                }
//            }
//            displayAllVaccine();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//    }
//    public void displayAllVaccine(){
//        if(vaccines.isEmpty()){
//             System.err.println("No vaccines found.");
//        }else{
//            System.err.println("All vaccines: ");
//        for(Vaccine vacc : vaccines){
//            System.out.println(vacc);
//        }}
//    }
//    public void addVaccine(Vaccine vacc){
//        vaccines.add(vacc);
//        System.out.println("Vaccine added!");
//    }
//    public void deleteVaccine(){//delete by code
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter code to remove: ");
//        String code = sc.nextLine().trim();
//        boolean removed = vaccines.removeIf(s->s.getCode().equalsIgnoreCase(code));
//        if(removed){
//            System.out.println("Vaccine " + code + " has been removed.");
//        }else{
//            System.out.println("Vaccine not found");
//        }
//    }
//    public void sortVaccineByName(){
////        Collections.sort(vaccines, (o1,o2)->o1.getName().compareTo(o2.getName()));
////        System.out.println("Sorted successlfully");
////    }
//        Collections.sort(vaccines, (o1, o2) -> o1.getName().compareTo(o2.getName()));
//        System.err.println("Vaccines sorted successfully!");
//    }
//    public void saveVaccineIntoFile(String fileName){
//        try{
//            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
//            for(Vaccine vacc : vaccines){
//                pw.println(vacc.toString());
//            }
//            System.out.println("Saved file successfully!");
//            pw.close();
//        }catch(FileNotFoundException nfe){
//            System.out.println("File not found!");
//        }catch(IOException ioe){
//            Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ioe);
//        }
//    }
//    
//    public Vaccine inputVaccine(){
//        String name = Inputter.getStringFromInput("name");
//        String code = Inputter.getStringFromInput("code");
//        int quantity = Inputter.getIntFromInput("quantity");
//        Date expirationDate = Inputter.getDateFromInput("expiration date");
//        double price = Inputter.getDoubleFromInput("price");
//        Date lastInjectedDate =Inputter.getDateFromInput("last injected date");
//        return new Vaccine(code, name, quantity, expirationDate,price,lastInjectedDate);
//    }
//    
//    @Override
//    public void execute(int choice) {
//        switch(choice){
//            case 1:
//                loadVaccinesFromFile("vaccines_input.txt");
//                break;
//            case 2:
//                Vaccine vacc = inputVaccine(); 
//                addVaccine(vacc);
////                saveVaccineIntoFile("vaccines_input.txt");
//                displayAllVaccine();
//                break;
//            case 3://delete
//                deleteVaccine();
//                break;
//            case 4://sort
//                sortVaccineByName();
//                displayAllVaccine();
//                break;
//            case 5: //save
//                saveVaccineIntoFile("vaccines_input.txt");
//                break;
//            case 6: //exit
//                break;
//            default:
//                System.err.println("Invalid choice!");
//        }
//    }
//    
//    public static void main(String[] args)  throws ParseException, IOException{
//        VaccineManager vacc = new VaccineManager();
//        vacc.run();
//    }
//    }


import java.util.*;
import java.io.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VaccineManager extends Menu {

    private List<Vaccine> vaccines;
    public void addVaccine(Vaccine vacc){
        vaccines.add(vacc);
        System.out.println("Vaccine added!");
    }

    public VaccineManager() {
        super("\nVaccin Managerment System",
                Arrays.asList(new String[]{"Display All Vaccines From File",
                    "Add a Vaccine",
                    "Delete a Vaccine by code",
                    "Sort Vaccines by Name",
                    "Save to File",
                    "Exit"}));
        vaccines = new ArrayList<>();
    }
    public Vaccine inputVaccine(){
        String name = Inputter.getStringFromInput("name");
        String code = Inputter.getStringFromInput("code");
        int quantity = Inputter.getIntFromInput("quantity");
        Date expirationDate = Inputter.getDateFromInput("expiration date");
        double price = Inputter.getDoubleFromInput("price");
        Date lastInjectedDate =Inputter.getDateFromInput("last injected date");
        return new Vaccine(code, name, quantity, expirationDate,price,lastInjectedDate);
    }
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                loadVaccineFromFile("vaccines_input.txt");
                break;
            case 2:
                Vaccine vacc = inputVaccine(); 
                addVaccine(vacc);
//                saveVaccineIntoFile("vaccines_input.txt");
                displayAllVaccines();
                break;
            case 3:
                deleteVaccine();
                break;
            case 4:
                sortVaccines();
                displayAllVaccines();
                break;
            case 5:
                saveVaccinesToFile("vaccines_input.txt");
                break;
            case 6:
                System.err.println("Exited. Bye bye");
                break;
            default:
                System.err.println("Invalid choice. Please try again.");
        }
    }

    private void saveVaccinesToFile(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filename));
            for (Vaccine vaccine : vaccines) {
                writer.println(vaccine.toString());
            }
            System.err.println("Vaccines saved to file.");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addVaccine() {
        System.err.println("\nAdd a Vaccine");
        String code = Inputter.getStringFromInput("code");

        Vaccine isExist = new Vaccine(code);

        //đã tồn tại vaccine
        if (!vaccines.contains(isExist)) {
            String name = Inputter.getStringFromInput("name");
            int quantity = Inputter.getIntFromInput("quantity");
            Date expirationDate = Inputter.getDateFromInput("Enter expiration date (dd/MM/yyyy):");
            double price = Inputter.getDoubleFromInput("price");
            Date lastInjectedDate = Inputter.getDateFromInput("Enter last injected date (dd/MM/yyyy):");
            Vaccine vaccine = new Vaccine(name, code, quantity, expirationDate, price,
                    lastInjectedDate);
            vaccines.add(vaccine);
            System.err.println("Vaccine added successfully.");
        } else {
            System.err.println("Vaccine is exist in the list");
        }
    }

    //using Predicate and lamda for searching inside method removeif
    private void deleteVaccine() {
        Scanner scanner = new Scanner(System.in);
        System.err.println("\nDelete a Vaccine by code");
        System.out.print("Enter the code of the vaccine to delete: ");
        String code = scanner.nextLine();

        boolean removed = vaccines.removeIf(v -> v.getCode().equals(code));
        if (removed) {
            System.err.println("Vaccine deleted successfully.");
            displayAllVaccines();
        } else {
            System.err.println("Vaccine not found.");
        }
    }

    //Sort vaccines by name
    private void sortVaccines() {
        System.err.println("Sort vaccines by name");
        Collections.sort(vaccines, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.err.println("Vaccines sorted successfully!");
    }

    private void displayAllVaccines() {
        if (vaccines.isEmpty()) {
            System.err.println("No vaccines found.");
        } else {
            System.err.println("\nAll Vaccines:");
            for (Vaccine vaccine : vaccines) {
                System.out.println(vaccine);
            }
        }
    }

    public void loadVaccineFromFile(String fileName){
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    if(vaccines.isEmpty()){
        System.out.println("No vaccines found");
    }else{
    try {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            String[] linearr = line.split(",");
//            vaccines.add(new Vaccine (linearr[0], linearr[1], Integer.parseInt(linearr[2]),dateFormat.parse(linearr[3]), Double.parseDouble(linearr[4]),dateFormat.parse(linearr[5])));
            if (linearr.length == 6) {
                    String code = linearr[0].split("=")[1];
                    String name = linearr[1].split("=")[1];

                    //kiểm tra định dạng quantity 
                    String quantity_string = linearr[2].split("=")[1];
                    boolean quantity_bool = Validation.isNumericInt(quantity_string);

                    //kiểm tra định dạng expirationDate
                    String expirationDate_string = linearr[3].split("=")[1];
                    boolean expirationDate_bool = Validation.isValidDate(expirationDate_string, "dd/MM/yyyy");

                    //kiểm tra định dạng price
                    String price_string = linearr[4].split("=")[1];
                    boolean price_bool = Validation.isNumericDouble(price_string);

                    //kiểm tra định dạng lastInjectedDate
                    String lastInjectedDate_string = linearr[5].split("=")[1];
                    boolean lastInjectedDate_bool = Validation.isValidDate(lastInjectedDate_string, "dd/MM/yyyy");

                    if (quantity_bool && price_bool && expirationDate_bool && lastInjectedDate_bool) {
                        int quantity = Integer.parseInt(quantity_string);
                        double price = Double.parseDouble(price_string);
                        Date expirationDate = Validation.parseDate(expirationDate_string);
                        Date lastInjectedDate = Validation.parseDate(lastInjectedDate_string);
                    
                        Vaccine vaccine = new Vaccine(code, name, quantity,
                                expirationDate, price, lastInjectedDate);
                        vaccines.add(vaccine);
                    }
                }
        }
        br.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found " + fileName);
    } catch (IOException ex) {
        System.out.println("An error occurred while reading the file");
    }}
    }
    
    //load file and check error for quantity, price, expirationDate,lastInjectedDate if incorrect format
    private void loadVaccinesFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length == 6) {
                    String code = data[0].split("=")[1];
                    String name = data[1].split("=")[1];

                    //kiểm tra định dạng quantity 
                    String quantity_string = data[2].split("=")[1];
                    boolean quantity_bool = Validation.isNumericInt(quantity_string);

                    //kiểm tra định dạng expirationDate
                    String expirationDate_string = data[3].split("=")[1];
                    boolean expirationDate_bool = Validation.isValidDate(expirationDate_string, "dd/MM/yyyy");

                    //kiểm tra định dạng price
                    String price_string = data[4].split("=")[1];
                    boolean price_bool = Validation.isNumericDouble(price_string);

                    //kiểm tra định dạng lastInjectedDate
                    String lastInjectedDate_string = data[5].split("=")[1];
                    boolean lastInjectedDate_bool = Validation.isValidDate(lastInjectedDate_string, "dd/MM/yyyy");

                    if (quantity_bool && price_bool && expirationDate_bool && lastInjectedDate_bool) {
                        int quantity = Integer.parseInt(quantity_string);
                        double price = Double.parseDouble(price_string);
                        Date expirationDate = Validation.parseDate(expirationDate_string);
                        Date lastInjectedDate = Validation.parseDate(lastInjectedDate_string);

                        Vaccine vaccine = new Vaccine(code, name, quantity,
                                expirationDate, price, lastInjectedDate);
                        vaccines.add(vaccine);
                    }
                }
            }
            displayAllVaccines();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        VaccineManager manager = new VaccineManager();
        manager.run();
    }
}
