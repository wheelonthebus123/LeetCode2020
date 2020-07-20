public class MaximumSumofTwoNonOverlappingSubarrays_1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        for(int i=1; i<n; ++i) A[i] += A[i-1];

        int ret = A[L+M-1], Lmax = A[L-1], Mmax = A[M-1];
        for(int i=L+M; i<n; ++i)
        {
            Lmax = Math.max(Lmax, A[i-M] - A[i-L-M]);
            Mmax = Math.max(Mmax, A[i-L] - A[i-L-M]);
            ret = Math.max(ret, Math.max(Lmax + A[i] - A[i-M], Mmax + A[i] - A[i-L]));
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}