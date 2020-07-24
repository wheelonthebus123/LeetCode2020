public class NumberofStepstoReduceaNumbertoZero_1342 {
    public int numberOfSteps (int num) {
        int r = 0;
        if(num==0) return r;
        while(num>0){
            r += (num&1)==1?2:1;
            num >>= 1;
        }
        return r-1;
    }
}