import java.util.*;

public class MinimumKnightMoves_1197 {
    Map<String, Integer> map = new HashMap<>();
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if(x+y==0) return 0;
        if(x+y==2) return 2;
        String key = x+":"+y;
     //   System.out.println(key);
        if(!map.containsKey(key)){
            int a = minKnightMoves(x-1, y-2);
            int b = minKnightMoves(x-2, y-1);
            map.put(key, Math.min(a,b)+1);
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}