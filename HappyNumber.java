import java.time.chrono.IsoChronology;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    static int getNext (int n)
    {
        int ret = 0;
        while(n>0)
        {
            int d = n%10;
            ret += d*d;
            n = n/10;
        }
        return ret;
    }

    static public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n))
        {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        isHappy(19);
    }
}