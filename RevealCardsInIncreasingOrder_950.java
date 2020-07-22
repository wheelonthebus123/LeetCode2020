import java.util.*;

public class RevealCardsInIncreasingOrder_950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; ++i) q.add(i);
        int[] ret = new int[n];
        int cur = 0;

        while(!q.isEmpty()){
            ret[q.poll()] = deck[cur++];
            if(!q.isEmpty()) q.add(q.poll());
        }

        return ret;
    }
}