import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("==================================");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 6.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.println("1. Add employee");
        System.out.println("2. View all employees");
        System.out.println("3. Search employee by ID");
        System.out.println("4. Update employee");
        System.out.println("5. Delete employee");
        System.out.println("6. Exit");
        System.out.println("----------------------------");
    }

    private static void addEmployee() {
        System.out.println("\nADD EMPLOYEE");

        int id = readPositiveInt("Enter employee ID: ");

        if (manager.findById(id) != null) {
            System.out.println("An employee with this ID already exists.");
            return;
        }

        String name = readText("Enter employee name: ");
        String department = readText("Enter department: ");
        double salary = readNonNegativeDouble("Enter salary: ");

        Employee employee = new Employee(id, name, department, salary);

        if (manager.addEmployee(employee)) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Could not add employee. ID may already exist.");
        }
    }

    private static void viewAllEmployees() {
        List<Employee> employees = manager.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        printTableHeader();
        for (Employee employee : employees) {
            employee.display();
        }
    }

    private static void searchEmployee() {
        int id = readPositiveInt("Enter employee ID to search: ");
        Employee employee = manager.findById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            printTableHeader();
            employee.display();
        }
    }

    private static void updateEmployee() {
        int id = readPositiveInt("Enter employee ID to update: ");
        Employee existing = manager.findById(id);

        if (existing == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("Current details:");
        printTableHeader();
        existing.display();

        String name = readText("Enter new name: ");
        String department = readText("Enter new department: ");
        double salary = readNonNegativeDouble("Enter new salary: ");

        if (manager.updateEmployee(id, name, department, salary)) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    private static void deleteEmployee() {
        int id = readPositiveInt("Enter employee ID to delete: ");

        if (manager.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void printTableHeader() {
        System.out.printf("%-8s %-20s %-18s %s%n",
                "ID", "NAME", "DEPARTMENT", "SALARY");
        System.out.println("------------------------------------------------------------");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Value must be greater than zero.");
        }
    }

    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value) && value >= 0) {
                    return value;
                }
                System.out.println("Salary must be a non-negative number.");
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid numeric salary.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("This field cannot be empty.");
            } else if (value.contains("|")) {
                System.out.println("The | character is not allowed.");
            } else {
                return value;
            }
        }
    }
}
