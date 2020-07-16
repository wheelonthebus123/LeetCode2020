import java.util.*;

public class PacificAtlanticWaterFlow_417 {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if(matrix == null) return ret;
        int m = matrix.length;
        if(m==0) return ret;
        int n = matrix[0].length;
        if(n==0) return ret;

        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueA = new LinkedList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<m; ++i)
        {
            queueP.offer(new int[]{i, 0});
            queueA.offer(new int[]{i, n-1});
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }

        for(int j=0; j<n; ++j)
        {
            queueP.offer(new int[]{0, j});
            queueA.offer(new int[]{m-1, j});
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
        }

        bfs(pacific, queueP, matrix);
        bfs(atlantic, queueA, matrix);

        for(int i=0; i<m; ++i)
        {
            for(int j=0; j<n; ++j)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    ret.add(Arrays.asList(new Integer[] {i, j}));
                }
            }
        }

        return ret;
    }

    void bfs(boolean[][] visited, Queue<int[]> que, int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        while(!que.isEmpty())
        {
            int[] cor = que.poll();
            for(int[] d : dir)
            {
                int x = cor[0] + d[0];
                int y = cor[1] + d[1];
                if(x>=0 && x<m && y>=0 && y<n && !visited[x][y] && matrix[cor[0]][cor[1]]<=matrix[x][y])
                {
                    visited[x][y] = true;
                    que.offer(new int[]{x, y});
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}