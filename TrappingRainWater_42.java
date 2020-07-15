import java.util.*;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int ret = 0;

        for(int i=0; i<height.length; ++i)
        {
            while(!stk.empty() && height[i]>height[stk.peek()])
            {
                int bot = height[stk.pop()];
                if(!stk.empty())
                {
                    int top = Math.min(height[i], height[stk.peek()]);
                    ret += (top - bot) * (i - stk.peek() - 1);
                }
            }
            stk.push(i);
            System.out.println(stk.toString());
            System.out.println("i="+i+" ret="+ret);
        }
        return ret;
    }

    public int trap1(int[] height) {
        int l = 0, r = height.length-1, level = 0;;
        int all = 0, block = 0;

        while(l<=r)
        {
            int newLevel = Math.min(height[l], height[r]);
            System.out.println(l + " " + r  + " " + level + " " + newLevel);
            if(newLevel > level){
                all += (newLevel - level) * (r-l+1); 
                level = newLevel;
            }
            if(height[l]<height[r])
            {
                block += height[l++];
            }else{
                block += height[r--];
            }
            System.out.println(all + " " + block);
            System.out.println();
        }
        return all - block;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1}; 
        TrappingRainWater_42 sol = new TrappingRainWater_42();
        sol.trap1(height);
    }
}