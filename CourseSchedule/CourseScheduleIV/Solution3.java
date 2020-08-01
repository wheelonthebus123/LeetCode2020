package CourseSchedule.CourseScheduleIV;
import java.util.*;

public class Solution3 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] path = new int[n][n];
        for(int[] p : prerequisites){
            path[p[0]][p[1]] = 1;
        }

        for(int k=0; k<n; ++k){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    path[i][j] |= path[i][k]&path[k][j];
                }
            }
        }

        List<Boolean> ret = new ArrayList<>();
        for(int[] q : queries){
            ret.add(path[q[0]][q[1]] == 1);
        }

        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}