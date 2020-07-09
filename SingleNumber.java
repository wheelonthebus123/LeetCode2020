public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums)
        {
            ret = ret^i;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}