import java.util.Scanner;

// HRHelpDeskSystem class is the entry point for the HR Help Desk System
public class HRHelpDeskSystem {
    public static void main(String[] args) {
        HRHelpDesk helpDesk = new HRHelpDesk(); // Create an instance of the HRHelpDesk class
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("========== Welcome to HR Help Desk System ==========");
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Print Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. Get Employee Salary");
            System.out.println("7. Update Details");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Read the user's choice
            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine(); // Read employee name
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine(); // Read employee department
                    System.out.print("Enter employee email: ");
                    String email = scanner.nextLine(); // Read employee email
                    System.out.print("Enter employee phone number: ");
                    String phoneNumber = scanner.nextLine(); // Read employee phone number
                    double salary;
                    do {
                        System.out.print("Enter employee salary: ");
                        salary = scanner.nextDouble(); // Read employee salary
                        if (salary < 0) {
                            System.out.println("Invalid salary. Please enter a non-negative value.");
                        }
                    } while (salary < 0);
                    Employee employee = new Employee(name, department, email, phoneNumber, salary); // Create an Employee object
                    helpDesk.addEmployee(employee); // Add the employee to the help desk
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    helpDesk.printEmployees(); // Print the list of employees
                    break;
                case 3:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name to search: ");
                    String searchName = scanner.nextLine(); // Read the employee name to search
                    helpDesk.searchEmployee(searchName); // Search for the employee
                    break;
                case 4:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name to remove: ");
                    String removeName = scanner.nextLine(); // Read the employee name to remove
                    helpDesk.removeEmployee(removeName); // Remove the employee
                    break;
                case 5:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name to update salary: ");
                    String updateName = scanner.nextLine(); // Read the employee name
                    double newSalary;
                    do {
                        System.out.print("Enter the new salary: ");
                        newSalary = scanner.nextDouble(); // Read the new salary
                        if (newSalary < 0) {
                            System.out.println("Invalid salary. Please enter a non-negative value.");
                        }
                    } while (newSalary < 0);
                    helpDesk.updateSalary(updateName, newSalary); // Update the salary of the employee
                    break;
                case 6:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name to get salary: ");
                    String salaryName = scanner.nextLine(); // Read the employee name
                    salary = helpDesk.getEmployeeSalary(salaryName);
                    if (salary >= 0) {
                        System.out.println("Employee's Salary: " + salary);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 7:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter employee name to update details: ");
                    String updateDetailsName = scanner.nextLine(); // Read the employee name
                    helpDesk.updateEmployeeDetails(updateDetailsName);
                    break;
                case 8:
                    System.out.println("========== Exiting HR Help Desk System ==========");
                    scanner.close();
                    System.exit(0); // Exit the program (The standard code is 0).
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}