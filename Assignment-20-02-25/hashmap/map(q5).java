import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List employees = new ArrayList();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map groupedEmployees = new HashMap();

        for (int i = 0; i < employees.size(); i++) {
            Employee emp = (Employee) employees.get(i);
            if (!groupedEmployees.containsKey(emp.department)) {
                groupedEmployees.put(emp.department, new ArrayList());
            }
            ((List) groupedEmployees.get(emp.department)).add(emp);
        }

        System.out.println("Grouped Employees: " + groupedEmployees);
    }
}
