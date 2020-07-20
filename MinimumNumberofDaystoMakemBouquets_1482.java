public class MinimumNumberofDaystoMakemBouquets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = 10^9;
        int n = bloomDay.length;
        if(m*k>n) return -1;
        while(l<r){
            int mid = l+(r-l)/2;
            int f = 0, b = 0;
            for(int i=0; i<n; ++i){
                if(bloomDay[i]<=mid){
                    f += 1;
                    if(f>=k){
                        b++;
                        f -= k;
                    }
                }else{
                    f = 0;
                }
            }
            if(b<m){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        int[] bloomDay = new int[] {7,7,7,7,12,7,7};
        MinimumNumberofDaystoMakemBouquets_1482 sol = new MinimumNumberofDaystoMakemBouquets_1482();
        sol.minDays(bloomDay, 2, 3);
    }
}