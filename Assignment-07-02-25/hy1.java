interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    String specialty;
    
    Chef(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }
    
    
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

class Waiter extends Person implements Worker {
    int tablesAssigned;
    
    Waiter(String name, int age, int tablesAssigned) {
        super(name, age);
        this.tablesAssigned = tablesAssigned;
    }
    
  
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
}
