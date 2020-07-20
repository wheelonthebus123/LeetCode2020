import java.util.Arrays;

public class TwoSumLessThanK_1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length-1, max = -1;

        while(l<r)
        {
            int res = A[l] + A[r];
            if(res<K){
                max = Math.max(max, res);
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}