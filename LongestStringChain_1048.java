import java.util.*;

//import sun.security.util.Length;

public class LongestStringChain_1048 {
    public int longestStrChain(String[] words) {
        int ret = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));   
        Map<String, Integer> dp = new HashMap<>();
        for(String w : words){
            if(dp.containsKey(w)) continue;
            int best = 0;
            for(int i=0; i<w.length(); ++i){
                String prev = w.substring(0, i) + w.substring(i+1);//remove i-th char
                best = Math.max(best, dp.getOrDefault(prev, 0)+1);
            }
            dp.put(w, best);
            ret = Math.max(ret, best);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        String[] list = new String[]{"a", "aa"};
        Arrays.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);
    }
}