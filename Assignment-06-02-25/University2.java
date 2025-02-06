import java.util.*;

// Course class (Aggregation - Students and Professors can exist independently)
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: Prof. " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

// Professor class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void showEnrolledCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("- " + course.courseName);
        }
    }
}

// Main class to demonstrate University Management System
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");
        
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");
        
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);
        
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);
        
        course1.showCourseDetails();
        course2.showCourseDetails();
        
        student1.showEnrolledCourses();
        student2.showEnrolledCourses();
    }
}
