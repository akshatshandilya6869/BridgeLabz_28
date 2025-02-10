
import java.util.ArrayList;
import java.util.List;

// Abstract class representing a general Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis; // Sensitive data (Encapsulation)

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public abstract double calculateBill(); // Abstract method for billing

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    protected String getDiagnosis() { // Restricted access
        return "Diagnosis: " + diagnosis;
    }
}

// Interface for managing medical records
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private List<String> records;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// Main class for testing
public class HospitalManagementSystem {
    public static void processPatient(Patient patient) {
        System.out.println(patient.getPatientDetails());
        System.out.println("Total Bill: $" + patient.calculateBill());

        if (patient instanceof MedicalRecord) {
            MedicalRecord medicalRecord = (MedicalRecord) patient;
            medicalRecord.addRecord("Initial checkup completed.");
            System.out.println("Medical Records: " + medicalRecord.viewRecords());
        }

        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Patient inPatient = new InPatient("P001", "John Doe", 45, "Pneumonia", 5, 500.00);
        Patient outPatient = new OutPatient("P002", "Jane Smith", 30, "Flu", 100.00);

        processPatient(inPatient);
        processPatient(outPatient);
    }
}

