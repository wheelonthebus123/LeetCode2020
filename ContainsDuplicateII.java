import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int l = nums.length;
        for(int i=0; i<l; ++i)
        {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int len = nums.length;
        Set<Integer> set = new HashSet<Integer>(len);

        int i=0;
        for(; i<=k && i<len; ++i)
        {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        if(i==len) return false;

        i = 0;
        while(i+k+1<len)
        {
            set.remove(nums[i]);
            int v = nums[i+k+1];
            if(set.contains(v)) return true;
            set.add(v);
            i++;
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}