public class Minesweeper_529 {
    int m, n;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        helper(click[0], click[1], board);
        return board;
    }

    void helper(int i, int j, char[][] board){
        if(board[i][j]=='M'){
            board[i][j] = 'X';
        }else if(board[i][j] == 'E'){
            int mines = 0;
            for(int[] d : dir){
                int ii = i+d[0];
                int jj = j+d[1];
                if(ii>=0 && ii<m && jj>=0 && jj<n && board[ii][jj]=='M'){
                    mines++;
                }
            }
            if(mines>0){
                board[i][j] = (char)('0'+mines);
            }else{
                board[i][j] = 'B';
                for(int[] d : dir){
                    int ii = i+d[0];
                    int jj = j+d[1];
                    if(ii>=0 && ii<m && jj>=0 && jj<n){
                        helper(ii, jj, board);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}