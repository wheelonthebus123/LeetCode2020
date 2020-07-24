public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums)
        {
            ret = ret^i;
        }
        return ret;
    }
}