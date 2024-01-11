/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
class Employee {
    private String employeeID;
    private String name;
    private String dateJoined;
    private double factor;
    private int salary;

    public Employee(String employeeID, String name, String dateJoined, double factor, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.dateJoined = dateJoined;
        this.factor = factor;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                ", factor=" + factor +
                ", salary=" + salary +
                '}';
    }
}

