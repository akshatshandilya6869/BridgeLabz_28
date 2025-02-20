class Policy{


    int policyNumber;
    String policyHolderName;
    int expiryDate;
    String coverageType;
    int premiumAmount;
   
    Policy(int policyNumber, String policyHolderName, int expiryDate, String coverageType, int premiumAmount){
   
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
   
    }
   
    public void display(){
   
        System.out.println("Policy number is "+this.policyNumber);
        System.out.println("Policy Holder name is "+this.policyHolderName);
        System.out.println("Policy expiry date is "+this.expiryDate);
        System.out.println("Policy coverage type is "+this.coverageType);
        System.out.println("Policy premium amount is "+this.premiumAmount);
        System.out.println();
   
    }


}


import java.util.*;


class InsurancePolicyManagementSystem{
   
    HashSet<Policy> hs;
    LinkedHashSet<Policy> ls;
    TreeSet<Policy> ts;




    InsurancePolicyManagementSystem(){
       
        this.hs = new HashSet<>();
        this.ls = new LinkedHashSet<>();
        this.ts = new TreeSet<>(new Comparator<Policy>(){
            //overiding the compare method of Treeset
            @Override
            public int compare(Policy p1, Policy p2){
                return p1.expiryDate-p2.expiryDate;
            }
        });
   
    }


    public void add(Policy p){
   
        for(Policy po : hs){
            if(po.policyNumber == p.policyNumber && !po.policyHolderName.equals(p.policyHolderName) ){
                System.out.println("Cannot add another user with used policy number");
                return;
            }
       
        }
       
        hs.add(p);
        ls.add(p);
       
        ts.add(p);
   
    }
   
    public void retrieveAllUnique(){
   
        Iterator<Policy> it = ls.iterator();
       
        while(it.hasNext()){
            Policy p = it.next();
            p.display();
        }
    }
   
    public void retrieveExpiring(){
   
        Iterator<Policy> it = ts.iterator();
        while(it.hasNext()){
            Policy p = it.next();
            if(p.expiryDate <= 30){
                p.display();
            }
            else
                break;
        }
   
    }
   
    public void retrieveCoverage(String coverageType){
   
        Iterator<Policy> it = ls.iterator();
        while(it.hasNext()){
            Policy p = it.next();
            if(p.coverageType.equals(coverageType)){
                p.display();
            }
        }
   
    }
   
    public void retrieveDuplicates(int policyNumber){
   
        Iterator<Policy> it = ls.iterator();
        while(it.hasNext()){
            Policy p = it.next();
            if(p.policyNumber == policyNumber){
                p.display();
            }
        }
   
    }
   
    public void remove(Policy p){
   
        hs.remove(p);
        ts.remove(p);
        ls.remove(p);
   
    }
   


}
public class Main{
public static void main(String[] args){
Policy p1=new Policy(1,"Arnav",50,"Health",6);
Policy p2=new Policy(1,"Akshat",20,"Auto",6);
Policy p3=new Policy(2,"Arihant",50,"Health",6);
Policy p4=new Policy(3,"bharat",50,"Medicine",6);
InsuranceManagementSystem In=new InsuranceManagementSystem();
In.add(p1);
In.add(p2);
13
In.add(p3);
In.add(p4);
System.out.println("Coverage :");
In.CoverageType("Health");
System.out.println();
System.out.println("Expiring in 30 days ");
In.Expiring();
System.out.println();
System.out.println("All unique policies ");
In.RetrieveAllUnique();
System.out.println();
System.out.println("Duplicate policies ");
In.DuplicatePolicy(1);
}
}
