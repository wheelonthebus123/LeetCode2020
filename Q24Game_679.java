import java.util.*;

public class Q24Game_679 {
    final double e = 0.001;
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int n:nums) list.add((double)n);
        return helper(list);
    }

    boolean helper(List<Double> list){
        if(list.size()==1){
            return Math.abs(list.get(0)-24) < e;
        }

        for(int i=0; i<list.size(); ++i){
            for(int j=i+1; j<list.size(); ++j){
                List<Double> tmp = new ArrayList<>();
                double v1 = list.get(i), v2 = list.get(j);
                tmp.addAll(Arrays.asList(v1+v2, v1-v2, v2-v1, v1*v2));
                if(Math.abs(v1)>e) tmp.add(v2/v1);
                if(Math.abs(v2)>e) tmp.add(v1/v2);

                list.remove(j);
                list.remove(i);
                for(double v : tmp){
                    list.add(v);
                    if(helper(list)) return true;
                    list.remove(list.size()-1);
                }
                list.add(i, v1);
                list.add(j, v2);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}