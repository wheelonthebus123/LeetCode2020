import java.util.*;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=0; i<nums.length; ++i){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; ++j){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l = j+1, r = nums.length-1;
                while(l<r){
                    if(l>j+1 && nums[l]==nums[l-1]){
                        l++;
                        continue;
                    } 
                    int s = nums[i]+nums[j]+nums[l]+nums[r];
                    if(s==target){
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }else if(s<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}