import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class to hold employee data
class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

    // Constructor
    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

public class EmployeeManager {

    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Employee Data by ID");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Show All Employees");
            System.out.println("5. Show Employee by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    showAllEmployees();
                    break;
                case 5:
                    searchEmployeeById();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    // Function 1: Add New Employee Data
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Position: ");
        String position = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(id, name, position, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully.");
    }

    // Function 2: Update Employee Data by ID
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.print("Enter new Name: ");
            employee.setName(scanner.nextLine());

            System.out.print("Enter new Position: ");
            employee.setPosition(scanner.nextLine());

            System.out.print("Enter new Salary: ");
            employee.setSalary(scanner.nextDouble());

            System.out.println("Employee data updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Function 3: Delete Employee by ID
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Function 4: Show All Saved Employee Data
    public static void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    // Function 5: Show Employee Data by searching with ID
    public static void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Helper function to find employee by ID
    private static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
