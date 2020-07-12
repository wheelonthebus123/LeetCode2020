
public class HowManyNumbersAreSmallerThantheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for(int i:nums)
        {
            count[i] ++;
        }

        for(int i=1; i<=100; ++i)
        {
            count[i] += count[i-1];
        }

        for(int i=0; i<nums.length; ++i)
        {
            res[i] = count[nums[i]];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}