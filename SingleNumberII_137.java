/*
if "1" occurs 3n (n is an integer) times, "1" should become "0"
need a bit operation @ such that 
0@1=1
1@1=1
1@1@1=0
unfortunately, cannot find such @
thus, use three numbers (r1, r2, r3) to record the number of times "1" occurs at each position
r1: a digit is "1" if its count mod 3==1; otherwise it is "0"
r2: a digit is "1" if its count mod 3==2; otherwise it is "0"
r3: a digit is "1" if its count mod 3==0; otherwise it is "0"
return r1|r2 because the number can appear once or twice
*/

public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {
        int r3=0, r2=0, r1=0;
        for(int it:nums){
            r3 = r2 & it;
            r2 = ((r1&it)|r2)&(~r3);
            r1 = (r1|it)&(~r2)&(~r3);
        }
        return r1|r2;
    }
}