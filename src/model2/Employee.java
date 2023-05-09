package src.model2;

public class Employee {
    public String name;
    
    public Employee(){

    }
    public Employee(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
    }
    public static void main(String[] args) {
        
    }
}
