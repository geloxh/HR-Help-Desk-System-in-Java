import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * == Employee class ==
 * Handles employee name, department, email, phone number and salary.
 * 
 */
class Employee {
    private String name;
    private String department;
    private String email;
    private String phoneNumber;
    private double salary;

    public Employee(String name, String department, String email, String phoneNumber, double salary) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary =salary ;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

/**
 * == HRHelpDesk class ==
 * handles the employee list and provides methods for, adding, searching
 * and removing employees
 * 
 */
class HRHelpDesk {
    private List<Employee> employeeList;

    public HRHelpDesk() {
        employeeList = new ArrayList<>(); // Initialize the employee list as an empty ArrayList
    }

    // Adds an employee to the employee list
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Prints the list of employees or displays a message if the list is empty
    public void printEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No Employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employeeList) {
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Phone Number: " + employee.getPhoneNumber());
                System.out.println("---------------------------");
            }
        }
    }

    // Searches for an employee by name and prints their details if found
    public void searchEmployee(String name) {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equalIsIgnoreCase(name)) {
                System.out.println("Employee Found: ");
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
            }
        }
    }
}   