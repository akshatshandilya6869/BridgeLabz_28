import java.util.*;

// Employee class
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void showEmployeeDetails() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

// Department class
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName, String position) {
        employees.add(new Employee(employeeName, position));
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            emp.showEmployeeDetails();
        }
    }
}

// Company class
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(String departmentName) {
        for (Department dept : departments) {
            if (dept.name.equals(departmentName)) {
                return dept;
            }
        }
        return null;
    }

    public void showCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showDepartmentDetails();
        }
    }
}

// Main class to test composition
public class CompanySystem {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        
        company.addDepartment("Engineering");
        company.addDepartment("Marketing");
        
        Department engineering = company.getDepartment("Engineering");
        if (engineering != null) {
            engineering.addEmployee("Alice", "Software Engineer");
            engineering.addEmployee("Bob", "DevOps Engineer");
        }
        
        Department marketing = company.getDepartment("Marketing");
        if (marketing != null) {
            marketing.addEmployee("Charlie", "SEO Specialist");
        }
        
        company.showCompanyDetails();
    }
}
