public class CandyCrush_723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean cont = true;

        while(cont){
            cont = false;
            for(int i=0; i<m ; ++i){
                for(int j=0; j<n; ++j){
                    int v = Math.abs(board[i][j]);
                    if(v == 0) continue;
                    //check horizontally
                    if(j+2<n && Math.abs(board[i][j+1])==v && Math.abs(board[i][j+2])==v){
                        cont = true;
                        board[i][j] = -v; board[i][j+1] = -v; board[i][j+2] = -v;
                    }
                    //check vertically
                    if(i+2<m && Math.abs(board[i+1][j])==v && Math.abs(board[i+2][j])==v){
                        cont = true;
                        board[i][j] = -v; board[i+1][j] = -v; board[i+2][j] = -v;
                    }
                }
            }

            if(cont){
                for(int j=0; j<n; ++j)
                {
                    int b = m-1;
                    for(int i=m-1; i>=0; --i){
                        if(board[i][j]>0){
                            board[b--][j] = board[i][j];
                        }
                    }
                    while(b>=0) board[b--][j] = 0;
                }
            }
        }
        return board;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}