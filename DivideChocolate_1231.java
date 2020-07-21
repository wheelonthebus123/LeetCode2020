public class DivideChocolate_1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        long sum = 0;
        for(long s : sweetness) sum += s;
        long l = 1, r = sum;
        while(l<r){
            long mid = l + (long)Math.ceil((r-l)/2.0);
            System.out.println(l + " " + r);
            if(!valid(sweetness, K, mid))
            {
                r = mid-1;
            }else{
                l = mid;
            }
        }
        return (int)l;
    }
    
    //return true if consecutive sweetness >= target when dividing into K+1 subarrays
    boolean valid(int[] sweetness, int K, long target){
        int count = 0;
        long cur = 0;
        for(long s : sweetness)
        {
            if(cur+s<target)
            {
                cur += s;
            }else{
                count++;
                cur = 0;
                if(count>=K+1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        DivideChocolate_1231 sol = new DivideChocolate_1231();
        sol.maximizeSweetness(new int[] {1,2,3,4,5,6,7,8,9}, 5);
    }
}