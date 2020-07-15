import java.util.*;

public class LargestRectangleinHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int area = 0;
        int[] newHeights = new int[heights.length+1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        newHeights[newHeights.length-1] = 0;

        for(int i=0; i<newHeights.length; ++i)
        {
            while(!stk.empty() && newHeights[i] < newHeights[stk.peek()])
            {
                int h = newHeights[stk.pop()];
                int l = stk.empty() ? -1 : stk.peek();
                area = Math.max(area, h * (i-l-1));
            }
            stk.push(i);
        }

        return area;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}