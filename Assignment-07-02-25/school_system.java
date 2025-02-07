class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    String subject;
    
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    
    void displayDetails() {
        super.displayDetails();
        System.out.println("Teaches: " + subject);
    }
}

class Student extends Person {
    int grade;
    
    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    
    
    void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;
    
    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
   
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}
