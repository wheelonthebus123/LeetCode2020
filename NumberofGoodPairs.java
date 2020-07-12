import java.util.HashMap;
import java.util.Map;

public class NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int v:nums)
        {
            if(counts.containsKey(v))
                counts.put(v, counts.get(v)+1);
            else
                counts.put(v, 1);
        }

        int ret = 0;
        for(Map.Entry e : counts.entrySet())
        {
            int n = (int) e.getValue();
            if(n>1)
            {
                ret += n*(n-1)/2;
            }
        }

        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}