import java.util.*;

public class OptimalAccountBalancing_465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> bal = new HashMap<>();
        for(int[] t : transactions){
            int a = t[0], b = t[1], c = t[2];
            bal.put(a, bal.getOrDefault(a, 0)-c);
            bal.put(b, bal.getOrDefault(b, 0)+c);
        }

        return settle(new ArrayList<>(bal.values()), 0);
    }

    int settle(List<Integer> list, int start){
        while(start<list.size() && list.get(start) == 0) start++;
        if(start==list.size()) return 0;
        int r = Integer.MAX_VALUE;
        for(int i=start+1; i<list.size(); ++i){
 
            if(list.get(start)*list.get(i)<0){
                list.set(i, list.get(i)+list.get(start));
                r = Math.min(r, 1+settle(list, start+1));
                list.set(i, list.get(i)-list.get(start));
            }
        }

        return r;
    }
    
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}