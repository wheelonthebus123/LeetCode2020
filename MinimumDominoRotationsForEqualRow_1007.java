public class MinimumDominoRotationsForEqualRow_1007 {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int ret = n+1;;
        for(int i=1; i<=6; ++i)
        {
            int countA = 0, countB = 0, countAB = 0;
            for(int j=0; j<n; ++j){
                if(A[j]==i) countA++;
                if(B[j]==i) countB++;
                if(A[j]==i && B[j]==i) countAB++;
                if(countA + countB - countAB == n){
                    ret = Math.min(ret, Math.min(n-countA, n-countB));
                }
            }
        }
        return ret == n+1 ? -1 : ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}