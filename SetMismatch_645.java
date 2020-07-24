public class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; ++i){
            while(nums[i]!=nums[nums[i]-1]){
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }

        int[] ret = new int[2];
        for(int i=0; i<n; ++i){
            if(nums[i]!=i+1){
                ret[0] = nums[i];
                ret[1] = i+1;
            }
        }
        return ret;
    }

    public int[] findErrorNums1(int[] nums) {
        int[] ret = new int[2];
        for(int i : nums){
            if(nums[Math.abs(i)-1]<0){
                ret[0] = Math.abs(i);
            }else{
                nums[Math.abs(i)-1] *= -1;
            }
        }

        for(int i=0; i<nums.length; ++i){
            if(nums[i]>0){
                ret[1] = Math.abs(i) + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        int[] nums = new int[]{1,2,2,4};
        SetMismatch_645 sol = new SetMismatch_645();
        sol.findErrorNums(nums);
    }
}