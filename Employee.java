public class Employee {
    private final int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.printf("%-8d %-20s %-18s %.2f%n",
                id, name, department, salary);
    }

    // Store one employee per line using | as a delimiter.
    public String toFileLine() {
        return id + "|" + name + "|" + department + "|" + salary;
    }

    public static Employee fromFileLine(String line) {
        String[] parts = line.split("\\|", -1);

        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid employee record: " + line);
        }

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        String department = parts[2];
        double salary = Double.parseDouble(parts[3]);

        return new Employee(id, name, department, salary);
    }
}
