import java.util.*;

public class NumberofMatchingSubsequences_792 {
    public int numMatchingSubseq(String S, String[] words) {
        List<StringBuilder>[] list = new List[128];
        for(char c = 'a'; c<='z'; c++) list[c] = new ArrayList<>();
        for(String w : words){
            list[w.charAt(0)].add(new StringBuilder(w));
        }
        int ret = 0;

        for(char c : S.toCharArray()){
            List<StringBuilder> temp = list[c];
            list[c] = new ArrayList<>();

            for(StringBuilder it : temp) {
                it.deleteCharAt(0);
                if(it.length()!=0){
                    list[it.charAt(0)].add(it);
                }else
                    ret++;
            }
        }

        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}