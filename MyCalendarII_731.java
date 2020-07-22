import java.util.*;

public class MyCalendarII_731 {
    List<int[]> meetings;

    public MyCalendarII_731() {
        meetings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        MyCalendar overlaps = new MyCalendar();
        for(int[] m : meetings){
            int a = Math.max(m[0], start);
            int b = Math.min(m[1], end);
            if(a<b){
                if(!overlaps.book(a, b)) return false;
            }
        }
        meetings.add(new int[] {start, end});
        return true;
    }

    private class MyCalendar {
        List<int[]> meetings = new ArrayList<>();
        boolean book(int s, int e)
        {
            for(int[] m : meetings){
                int a = Math.max(m[0], s);
                int b = Math.min(m[1], e);
                if(a<b) return false;
            }
            meetings.add(new int[] {s, e});
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}