package CourseSchedule.CourseScheduleII;
import java.util.*;

public class Solution {
    Set<Integer> path, visited;
    Map<Integer, Set<Integer>> preqs;
    List<Integer> schedule;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        path = new HashSet<>();
        visited = new HashSet<>();
        preqs = new HashMap<>();
        schedule = new ArrayList<>();
        for(int[] p : prerequisites){
            preqs.computeIfAbsent(p[0], k -> new HashSet<Integer>()).add(p[1]);
        }

        for(int c = 0; c<numCourses; ++c){
            path.add(c);
            if(!visited.contains(c) && hasCycle(c))
                return new int[0];
            path.remove(c);
        }

        int[] ret = new int[schedule.size()];
        for(int i=0; i<schedule.size(); ++i) ret[i] = schedule.get(i);
        return ret;
    }

    boolean hasCycle(int course){
        visited.add(course);
        if(preqs.containsKey(course)){
            for(int p : preqs.get(course)){
                if(path.contains(p)) return true;
                path.add(p);
                if(!visited.contains(p) && hasCycle(p)) return true;
                path.remove(p);
            }
        }
        schedule.add(course);
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}