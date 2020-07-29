import java.util.*;

public class MostStonesRemovedwithSameRoworColumn_947 {
    int isLands = 0;
    Map<Integer, Integer> f = new HashMap<>();
    public int removeStones(int[][] stones) {
        for(int[] s : stones){
            if(!f.containsKey(s[0])){
                f.put(s[0], s[0]);
                isLands ++;
            }
            
            if(!f.containsKey(~s[1])){
                f.put(~s[1], ~s[1]);
                isLands ++;
            }
        }
        for(int[] s : stones){
            union(s[0], ~s[1]);
        }
        return stones.length - isLands;
    }

    int find(int x){
        if(x == f.get(x)) return x;
        else return find(f.get(x));
    }

    void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            isLands--;
            f.put(x, y);
        }
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        int[][] inputs = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn_947 sol = new MostStonesRemovedwithSameRoworColumn_947();
        System.out.println(sol.removeStones(inputs));
    }
}