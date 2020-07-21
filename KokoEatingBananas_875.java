public class KokoEatingBananas_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = (int)1e9;
        while(l<r){
            int mid = l + (r-l)/2;
            if(valid(piles, H, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    
    boolean valid(int[] piles, int H, int target)
    {
        int count = 0;
        for(int p : piles){
            count += (int)Math.ceil(p/(double)target);
            if(count>H) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}