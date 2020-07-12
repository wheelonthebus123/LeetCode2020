import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for(int i : nums)
        {
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}