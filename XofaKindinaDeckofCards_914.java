import java.util.*;

public class XofaKindinaDeckofCards_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : deck){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        int ret = 0;
        for(int i : count.values()){
            ret = gcd(i, ret);
        }
        return ret>1;
    }

    int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}