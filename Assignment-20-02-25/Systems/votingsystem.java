import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        // Store votes in HashMap (Candidate -> Votes)
        Map votes = new HashMap();
        castVote(votes, "Alice");
        castVote(votes, "Bob");
        castVote(votes, "Alice");
        castVote(votes, "Carol");
        castVote(votes, "Bob");
        castVote(votes, "Alice");

        // Display votes in insertion order (LinkedHashMap)
        Map orderedVotes = new LinkedHashMap(votes);
        System.out.println("Votes in order of insertion: " + orderedVotes);

        // Display results sorted by candidate name (TreeMap)
        Map sortedVotes = new TreeMap(votes);
        System.out.println("Votes sorted by candidate name: " + sortedVotes);
    }

    public static void castVote(Map votes, String candidate) {
        if (votes.containsKey(candidate)) {
            votes.put(candidate, (Integer) votes.get(candidate) + 1);
        } else {
            votes.put(candidate, 1);
        }
    }
}
