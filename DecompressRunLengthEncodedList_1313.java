import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList_1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<nums.length; i += 2)
        {
            for(int j=0; j<nums[i]; ++j)
            {
                ret.add(nums[i+1]);
            }
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}