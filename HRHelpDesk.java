import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if (employee.getName().equalsIgnoreCase(name)) {
                System.out.println("Employee Found: ");
                System.out.println("Name: " + employee.getName());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Phone Number: " + employee.getPhoneNumber());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Removes an employee from the employee list by name
    public void removeEmployee(String name) {
        boolean removed = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equalsIgnoreCase(name)) {
                employeeList.remove(i);
                System.out.println("Employee removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee not found.");
        }
    }

    // Updates the salary of an existing employee
    public void updateSalary(String name, double newSalary) {
        boolean updated = false;
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employee.setSalary(newSalary);
                System.out.println("Salary updated successfully.");
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("Employee not found.");
        }
    }

    // Retrieves the salary of an employee
    public double getEmployeeSalary(String name) {
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase (name)) {
                return employee.getSalary();
            }
        }
        return -1; // Return -1 to indicate that employee was not found
    }

    // Updates any detail of an existing employee
    public void updateEmployeeDetails(String name) {
        Employee employeeToUpdate = null;
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                employeeToUpdate = employee;
                break;
            }
        }
        if (employeeToUpdate == null) {
            System.out.println("Employee not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the detail to update:");
        System.out.println("1. Name");
        System.out.println("2. Department");
        System.out.println("3. Email");
        System.out.println("4. Phone Number");
        System.out.println("5. Salary");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                employeeToUpdate.setName(newName);
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter the new department: ");
                String newDepartment = scanner.nextLine();
                employeeToUpdate.setDepartment(newDepartment);
                System.out.println("Department updated successfully.");
            case 3:
                System.out.print("Enter  the new email: ");
                String newEmail = scanner.nextLine();
                employeeToUpdate.setEmail(newEmail);
                System.out.println("Email updated successfully.");
                break;
            case 4:
                System.out.print("Enter the new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                employeeToUpdate.setPhoneNumber(newPhoneNumber);
                System.out.println("Phone Number updated successfully.");
                break;
            case 5:
                double newSalary;
                do {
                    System.out.print("Enter the new salary: ");
                    newSalary = scanner.nextDouble();
                    if (newSalary < 0) {
                        System.out.println("Invalid salary. Please enter a non-negative value.");
                    }
                } while (newSalary < 0);
                employeeToUpdate.setSalary(newSalary);
                System.out.println("Salary updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }
}