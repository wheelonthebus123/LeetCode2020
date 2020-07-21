public class FindtheSmallestDivisorGivenaThreshold_1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = (int)1e6;
        while(l<r)
        {
            int mid = l + (r-l)/2;
            int sum = 0;
            for(int n:nums){
                sum += Math.ceil(n/(double)mid);
            }
            if(sum>threshold) l = mid+1;
            else r = mid;
        }
        return (int)l;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        FindtheSmallestDivisorGivenaThreshold_1283 sol = new FindtheSmallestDivisorGivenaThreshold_1283();
        sol.smallestDivisor(new int[] {19}, 5);
    }
}