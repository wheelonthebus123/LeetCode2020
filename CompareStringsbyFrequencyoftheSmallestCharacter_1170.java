import java.util.*;

public class CompareStringsbyFrequencyoftheSmallestCharacter_1170 {
    int getFreq(String word)
    {
        int[] freq = new int[26];
        for(char c:word.toCharArray())
        {
            freq[c-'a']++;
        }
        for(int i=0; i<26; ++i)
        {
            if(freq[i]!=0)
                return freq[i];
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qF = new int[queries.length];
        for(int i=0; i<queries.length; ++i) qF[i] = getFreq(queries[i]);
        int[] wF = new int[words.length];
        for(int i=0; i<words.length; ++i) wF[i] = getFreq(words[i]);
        Arrays.sort(wF);

        int[] ret = new int[queries.length];
        for(int i=0; i<queries.length; ++i){
            int l = 0, r = wF.length-1;

            //find l as the first one with wF[l]>qF[i];
            //l will also be the lenth of words whose frequence<=qF[i]
            while(l<=r)
            {
                int m = l + (r-l)/2;
                if(wF[m]<=qF[i])
                {
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
            ret[i] = words.length - l;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        CompareStringsbyFrequencyoftheSmallestCharacter_1170 sol = new CompareStringsbyFrequencyoftheSmallestCharacter_1170();
        sol.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
    }
}