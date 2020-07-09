import java.util.HashSet;
import java.util.Set;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(char c: J.toCharArray())
        {
            set.add(c);
        }

        int ret = 0;
        for(char c:S.toCharArray())
        {
            if(set.contains(c))
            {
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}