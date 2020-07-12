public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int ret = 0;
        for(int i=0; i<rows; ++i)
        {
            for(int j=0; j<cols; ++j)
            {
                if(grid[i][j] == 1)
                {
                    ret += 4;
                    if(i-1>=0 && grid[i-1][j]==1) ret--;
                    if(i+1<rows && grid[i+1][j]==1) ret--;
                    if(j-1>=0 && grid[i][j-1]==1) ret--;
                    if(j+1<cols && grid[i][j+1]==1) ret--;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}