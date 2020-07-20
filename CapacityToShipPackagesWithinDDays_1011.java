public class CapacityToShipPackagesWithinDDays_1011 {
    public int shipWithinDays(int[] weights, int D) {
        int l = 0, r = 0;
        for(int w:weights)
        {
            l = Math.max(l, w);
            r += w;
        }

        while(l<r){
            int cap = l+(r-l)/2;//
            int need = 1;
            int cur = 0;
            for(int w:weights)
            {
                if(cur+w<=cap)
                {
                    cur += w;
                }else{
                    need++;
                    cur = w;
                }
            }
            if(need>D){
                l = cap+1;
            }else{
                r = cap;
            }
        }

        return l;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}