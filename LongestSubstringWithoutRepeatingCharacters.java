import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length();
        int ret = 0;
        Set<Character> set = new HashSet<>();
        while(l<=r && r<n)
        {
            if(set.contains(s.charAt(r)))
            {
                set.remove(s.charAt(l++));
            }
            else
            {
                ret = Math.max(ret, r-l+1);
                set.add(s.charAt(r++));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}