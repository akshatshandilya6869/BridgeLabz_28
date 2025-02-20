import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(new Comparator() {
            public int compare(Object o1, Object o2) {
                Patient p1 = (Patient) o1;
                Patient p2 = (Patient) o2;
                return p2.severity - p1.severity; // Higher severity first
            }
        });

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            Patient p = (Patient) queue.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
