public class SplitArrayLargestSum_410 {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for(long n : nums)
        {
            l = Math.max(l, n);
            r += n;
        }
        while(l<r)
        {
            long mid = l+(r-l)/2;
            if(valid(nums, mid, m))
            {
                r = mid;
            }else{
                l = mid+1;
            }
        }
        
        //r is always valid because 1) it is valid to start with 2) it is always valid on each step
        //upon exit, l==r because while(l<r). l=3, r=4, mid = 3 ==> l=mid+1=4==r
        return (int)r;
    }

    //return true if min-max <= target
    boolean valid(int[] nums, long target, int m)
    {
        int count = 0;
        long total = 0;
        for(long n:nums)
        {
            if(total+n<=target){
                total += n;
            }else{
                count++;
                if(count>m) return false;
                total = n;
            }
        }
        if(total>0) count++;
        return count<=m;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}