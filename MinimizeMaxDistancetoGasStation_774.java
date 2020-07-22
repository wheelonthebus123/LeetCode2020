public class MinimizeMaxDistancetoGasStation_774 {
    double E = 1e-6;
    int compare(double a, double b)
    {
        if(Math.abs(a-b)<=E) return 0;
        else if(a>b) return 1;
        else return -1;
    }
    
    public double minmaxGasDist(int[] stations, int K) {
        double l = E, r = 2000;
        while(compare(l, r)<=0)
        {
            double mid = l + (r-l)/2.0;
            if(valid(stations, K, mid))
            {
                if(compare(mid, 0)==0 || !valid(stations, K, mid-E)) return mid;
                r = mid-E;
            }else{
                l = mid+E;
            }
        }
        return l;
    }
    
    boolean valid (int[] stations, int K, double target)
    {  
        int n = stations.length;
        int added = 0;
        for(int i=1; i<n; ++i){
            double distance = (double)stations[i]-(double)stations[i-1];
            if(distance > target){
                added += (int)Math.floor(distance/target);
            }
            if(added>K) return false;
        }
        return true;
    }
}