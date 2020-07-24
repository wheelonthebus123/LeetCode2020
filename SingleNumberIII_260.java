public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int n:nums) diff ^= n;
        int setBit = diff & -diff;
        
        int[] ret = new int[2];
        for(int n:nums){
            if((n&setBit) == 0){
                ret[0] ^= n;
            }else{
                ret[1] ^= n;
            }
        }
        
        return ret;
    }
}