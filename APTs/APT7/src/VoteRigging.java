import java.util.Arrays;
import java.util.Collections;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        if (votes.length == 1) return 0;
        int counter = 0;
        Integer[] nums = Arrays.stream(votes).boxed().toArray( Integer[]::new);
        int maximum = Collections.max(Arrays.asList(nums));
        while (Math.max(maximum, votes[0]) != votes[0]) {
            for (int i = 1; i < votes.length; i++) {
                nums = Arrays.stream(votes).boxed().toArray( Integer[]::new);
                maximum = Collections.max(Arrays.asList(nums));
                if (votes[i] == maximum){
                    votes[i]--;
                    votes[0]++;
                    counter++;
                }
            }
        }
        nums = Arrays.stream(votes).boxed().toArray( Integer[]::new);
        maximum = Collections.max(Arrays.asList(nums));
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] == maximum){
                return counter + 1;
            }
        }
        return counter;
    }
}
