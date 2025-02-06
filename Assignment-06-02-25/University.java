import java.util.*;

// Faculty class (Aggregation - Faculty can exist independently of Departments)
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void showFacultyDetails() {
        System.out.println("Faculty: " + name + ", Specialization: " + specialization);
    }
}

// Department class (Composition - Exists only within University)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + name);
    }
}

// University class (Composition - Contains Departments, Aggregation - References Faculties)
class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.showDepartmentDetails();
        }
        System.out.println("Faculties:");
        for (Faculty fac : faculties) {
            fac.showFacultyDetails();
        }
    }
}

// Main class to demonstrate composition and aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Global University");
        
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");
        
        Faculty faculty1 = new Faculty("Dr. Smith", "Artificial Intelligence");
        Faculty faculty2 = new Faculty("Dr. Johnson", "Thermodynamics");
        
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        
        university.showUniversityDetails();
    }
}

