public class Policy {
    final int policynumber;
    String policyholdername;
    String coveragetype;
    int expirydate;


    Policy(int policynumber,String policyholdername,String coveragetype,int expirydate){
        this.policynumber=policynumber;
        this.policyholdername=policyholdername;
        this.coveragetype=coveragetype;
        this.expirydate=expirydate;
    }
    public void setPolicyholdername(String s){
        this.policyholdername=s;
    }
    public void setCoveragetype(String s){
        this.coveragetype=s;
    }
    public void setExpirydate(int s){
        this.expirydate=s;
    }
    public String getPolicyholdername() {
        return this.policyholdername;
    }
    public String getCoveragetype() {
        return this.coveragetype;
    }
    public int getExpirydate() {
        return this.expirydate;
    }
    public void display(){
        System.out.println("Policy number :"+this.policynumber+" PolicyHolderName :"+this.policyholdername+" Coverage : "+this.coveragetype+" Expirydate : "+this.expirydate);
    }
}
import java.util.*;


public class PolicyOperations {
    final private Map<Integer, Policy> policies = new HashMap<>();
    Map<Integer, Policy> lm = new LinkedHashMap<>();
    TreeMap<Integer, List<Policy>> tm = new TreeMap<>();


    public void add(Policy p) {
        policies.put(p.policynumber, p);
        lm.put(p.policynumber, p);
        tm.computeIfAbsent(p.expirydate, k -> new ArrayList<>()).add(p);
    }


    public void retrieveByNumber(int policynumber) {
        Policy p = policies.get(policynumber);
        if (p != null) {
            p.display();
        } else {
            System.out.println("Policy with number " + policynumber + " not found.");
        }
    }


    public void Expiring(){
        System.out.println("Policies expiring within 30 days:");
        for (Map.Entry<Integer, List<Policy>> entry : tm.headMap(30, true).entrySet()) {
            for (Policy p : entry.getValue()) {
                p.display();
            }
        }
    }


    public void showPolicyHolderName(String policyholdername){
        System.out.println("Policies for policyholder: " + policyholdername);
        for (Policy p : policies.values()) {
            if (p.getPolicyholdername().equalsIgnoreCase(policyholdername)) {
                p.display();
            }
        }
    }


    public void removeExpiringPolicies(){
        System.out.println("Removing expired policies...");
        List<Integer> policiesToRemove = new ArrayList<>();


        for (Map.Entry<Integer, List<Policy>> entry : tm.headMap(1, true).entrySet()) {
            for (Policy p : entry.getValue()) {
                policiesToRemove.add(p.policynumber);
            }
        }


        for (int policyNumber : policiesToRemove) {
            Policy p = policies.remove(policyNumber);
            lm.remove(policyNumber);
            tm.get(p.expirydate).remove(p);
            if (tm.get(p.expirydate).isEmpty()) {
                tm.remove(p.expirydate);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PolicyOperations policyOps = new PolicyOperations();


        // Adding some sample policies
        Policy policy1 = new Policy(101, "John Doe", "Health", 10);
        Policy policy2 = new Policy(102, "Jane Smith", "Auto", 20);
        Policy policy3 = new Policy(103, "Alice Johnson", "Home", 5);
        Policy policy4 = new Policy(104, "Bob Brown", "Travel", 50);


        // Add policies to the system
        policyOps.add(policy1);
        policyOps.add(policy2);
        policyOps.add(policy3);
        policyOps.add(policy4);


        // Retrieve policy by number
        System.out.println("Retrieve policy by number 101:");
        policyOps.retrieveByNumber(101);


        // Show all expiring policies (expiry date <= 30)
        System.out.println("\nPolicies expiring in 30 days or less:");
        policyOps.Expiring();


        // Show policies for a specific policyholder
        System.out.println("\nPolicies for policyholder 'Jane Smith':");
        policyOps.showPolicyHolderName("Jane Smith");


        // Remove expiring policies with expiry date of 0
        System.out.println("\nRemoving policies with expiry date 0 (none in this case):");
        policyOps.removeExpiringPolicies();


        // Show all expiring policies again after removal
        System.out.println("\nPolicies expiring in 30 days or less after removal:");
        policyOps.Expiring();
    }
}


