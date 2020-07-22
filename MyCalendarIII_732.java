import java.util.*;

public class MyCalendarIII_732 {
    TreeMap<Integer, Integer> timeLine;
    public MyCalendarIII_732() {
        timeLine = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        timeLine.put(start, timeLine.getOrDefault(start, 0)+1);
        timeLine.put(end, timeLine.getOrDefault(end, 0)-1);
        int ongoing = 0, ret = 0;
        for(int v : timeLine.values()){
            ongoing += v;
            ret = Math.max(ret, ongoing);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}