import java.util.Arrays;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; ++i){
            while(nums[i]>=1 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }

        for(int i=0; i<n; ++i){
            if(nums[i]!=i+1) return i+1;
        }
        return n+1;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        FirstMissingPositive_41 sol = new FirstMissingPositive_41();
    //    int[] nums = new int[]{1,3,4,2,2};
        int[] nums = new int[]{1,2,0};
        sol.firstMissingPositive(nums);
    }
}