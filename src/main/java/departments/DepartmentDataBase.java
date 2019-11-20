package departments;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDataBase {
    private static List<Department> listOfDepartments = new ArrayList<Department>();
    private static List<String> nameOfDepartments = new ArrayList<String>();

    public static List<Department> getListOfDepartments() {
        return listOfDepartments;
    }

    public static List<String> getNameOfDepartments() {
        return nameOfDepartments;
    }

    public static Department getDepartment(String name) {
        for (Department d : listOfDepartments) {
            if (d.getName().equalsIgnoreCase(name)) return d;
        }
        return null;
    }
}
