package lc2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * two-sum
 */
public class Twosum {
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();//value, index
        for (int i=0; i<nums.length; i++)
        {
            int u = nums[i];
            int v = target - u;
            if(map.containsKey(v))
            {
                return new int[] {map.get(v), i};
            }

            map.put(u, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] sol = twoSum(nums, 9);
        System.out.println(Arrays.toString(sol));
    }
}