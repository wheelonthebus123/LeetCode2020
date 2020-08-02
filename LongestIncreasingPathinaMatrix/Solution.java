package LongestIncreasingPathinaMatrix;

public class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int ret = 0;
    int m, n;
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if(m==0) return 0;
        n = matrix[0].length;
        if(n==0) return 0;
        
        dp = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(dp[i][j]<0) helper(matrix, i, j);
                ret = Math.max(ret, dp[i][j]);
            }
        }
        
        return ret;
    }

    void helper(int[][] matrix, int i, int j){
        dp[i][j] = 1;
        for(int[] d : dir){
            int ii = i + d[0];
            int jj = j + d[1];
            if(ii>=0 && ii<m && jj>=0 && jj<n && matrix[i][j]<matrix[ii][jj]){
                if(dp[ii][jj]<0){
                    helper(matrix, ii, jj);
                }
                dp[i][j] = Math.max(dp[i][j], dp[ii][jj]+1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        int[][] matrix = new int[][]{{3,4,5},{3,2,6},{2,2,1}};
        Solution sol = new Solution();
        sol.longestIncreasingPath(matrix);
    }
}