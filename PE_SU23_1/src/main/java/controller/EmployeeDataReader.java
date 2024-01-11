/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDataReader{
    public static List<Employee> readEmployeeData(String filePath) throws FileNotFoundException {
        List<Employee> employeeData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                if (values.length == 5) {
                    String employeeID = values[0];
                    String name = values[1];
                    String dateJoined = values[2];
                    double factor = Double.parseDouble(values[3].replaceAll("f", ""));
                    int salary = Integer.parseInt(values[4]);

                    Employee employee = new Employee(employeeID, name, dateJoined, factor, salary);
                    employeeData.add(employee);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
                
            }
        }catch (IOException ex) { 
            Logger.getLogger(EmployeeDataReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employeeData;
        }
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "employee.txt";
        List<Employee> employeeData = readEmployeeData(filePath);
        for (Employee employee : employeeData) {
            System.out.println(employee);
        }
    }
}

