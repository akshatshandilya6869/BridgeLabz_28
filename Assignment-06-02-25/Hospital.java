import java.util.*;

// Patient class (Association with Doctor)
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public String getName() {
        return name;
    }

    public void showDoctors() {
        System.out.println(name + " is consulting with:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.getName());
        }
    }
}

// Doctor class (Association with Patient)
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " is consulting:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Dr. " + doctor.getName() + " (" + doctor.specialization + ")");
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

// Main class to demonstrate association and communication
public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Alice", "Cardiology");
        Doctor doctor2 = new Doctor("Bob", "Neurology");
        
        Patient patient1 = new Patient("John Doe");
        Patient patient2 = new Patient("Jane Smith");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        patient1.addDoctor(doctor1);
        patient1.addDoctor(doctor2);
        patient2.addDoctor(doctor2);

        doctor1.consult(patient1);
        doctor2.consult(patient1);
        doctor2.consult(patient2);

        patient1.showDoctors();
        patient2.showDoctors();
        doctor1.showPatients();
        doctor2.showPatients();
    }
}
