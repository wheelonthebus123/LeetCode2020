public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return new int[0];
        int n = matrix[0].length;
        if(n==0) return new int[0];
        int[] ret = new int[m*n];
        
        int r = 0, c = 0;
        for(int i=0; i<m*n; ++i){
            ret[i] = matrix[r][c];
            if((r+c)%2 == 0){//moving up
                if(c==n-1) r++;
                else if(r == 0) c++;
                else {r--; c++;}
            }else{//moving down
                if(r==m-1) c++;
                else if(c==0) r++;
                else {r++; c--;}
            }
        }
        
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        DiagonalTraverse_498 sol = new DiagonalTraverse_498();
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        sol.findDiagonalOrder(matrix);
    }
}