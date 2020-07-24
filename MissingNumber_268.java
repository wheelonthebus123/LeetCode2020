public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int s = 0;
        for(int v:nums) s+=v;
        int n = nums.length;
        return n*(n+1)/2-s;
    }
}