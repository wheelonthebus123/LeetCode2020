import java.util.*;

public class MyCalendarI_729 {
    List<int[]> list;

    public  MyCalendarI_729() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] b : list){
            if (Math.max(b[0], start)<Math.min(b[1], end)){
                return false;
            }
        }

        list.add(new int[] {start, end});
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}