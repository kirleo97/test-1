package departments;

import staff.Employee;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> list;
    private int sumSalary;
    private int avrSalary;

    public Department(String name, List<Employee> list) {
        this.name = name;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getList() {
        return list;
    }

    public int getAvrSalary() {
        return avrSalary;
    }

    public void changeSalary(int salary) {
        sumSalary += salary;
        avrSalary = sumSalary/list.size();
    }
}
