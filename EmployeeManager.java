import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final ArrayList<Employee> employees = new ArrayList<Employee>();
    private final Path dataFile = Paths.get("employees.txt");

    public EmployeeManager() {
        loadFromFile();
    }

    public boolean addEmployee(Employee employee) {
        if (findById(employee.getId()) != null) {
            return false;
        }

        employees.add(employee);
        saveToFile();
        return true;
    }

    public Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String name,
                                  String department, double salary) {
        Employee employee = findById(id);

        if (employee == null) {
            return false;
        }

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        saveToFile();
        return true;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = findById(id);

        if (employee == null) {
            return false;
        }

        employees.remove(employee);
        saveToFile();
        return true;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<Employee>(employees);
    }

    private void loadFromFile() {
        if (!Files.exists(dataFile)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(dataFile)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Employee employee = Employee.fromFileLine(line);

                    // Avoid loading duplicate IDs from a manually edited file.
                    if (findById(employee.getId()) == null) {
                        employees.add(employee);
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println("Skipping invalid data line: " + line);
                }
            }
        } catch (IOException ex) {
            System.out.println("Could not read employee file: " + ex.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(dataFile)) {
            for (Employee employee : employees) {
                writer.write(employee.toFileLine());
                writer.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Could not save employee data: " + ex.getMessage());
        }
    }
}
