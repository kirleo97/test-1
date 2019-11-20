package staff;

public class Employee {
    private String fullName;
    private int salary;
    private String department;

    public Employee(String fullName, int salary, String department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
