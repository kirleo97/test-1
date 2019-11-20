package completion;

import departments.Department;
import departments.DepartmentDataBase;
import staff.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        readEmployees("C:\\Users\\kleonov\\Documents\\TestFiles\\empl.txt");
        writeEmployees();
    }

    public static void readEmployees(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String s;
            String[] mas;
            while (reader.ready()) {
                s = reader.readLine();
                mas = s.trim().split(" ");
                String fullName = mas[0] + " " + mas[1] + " " + mas[2];
                int salary = Integer.parseInt(mas[3]);
                String department = mas[4];
                Employee employee = new Employee(fullName, salary, department);
                addToDepartment(employee);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToDepartment(Employee employee) {
        String departmentName = employee.getDepartment();

        if (!DepartmentDataBase.getNameOfDepartments().contains(departmentName)) {
            Department department = new Department(departmentName, new ArrayList<Employee>());
            DepartmentDataBase.getNameOfDepartments().add(departmentName);
            DepartmentDataBase.getListOfDepartments().add(department);
            department.getList().add(employee);
            department.changeSalary(employee.getSalary());
        } else {
            Department department = DepartmentDataBase.getDepartment(departmentName);
            department.getList().add(employee);
            department.changeSalary(employee.getSalary());
        }
    }

    public static void writeEmployees() {
        for (Department department : DepartmentDataBase.getListOfDepartments()) {
            System.out.println();
            System.out.println("Отдел " + department.getName() + ":");
            for (Employee employee : department.getList()) {
                System.out.println(employee.getFullName() + ", заработная плата - " + employee.getSalary());
            }
            System.out.println("Средняя заработная плата по отделу = " + department.getAvrSalary());
        }
    }
}
