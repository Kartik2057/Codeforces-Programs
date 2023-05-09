package com.company.model;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
    }
}