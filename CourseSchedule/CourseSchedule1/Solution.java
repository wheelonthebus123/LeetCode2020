package CourseSchedule.CourseSchedule1;
import java.util.*;

public class Solution {
    Set<Integer> visited;   
    Set<Integer> path;
    Map<Integer, Set<Integer>> preq;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new HashSet<>();
        path = new HashSet<>();
        preq = new HashMap<>();
        for(int[] p : prerequisites){
           preq.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
        }

        for(int c = 0; c<numCourses; ++c){
            path.add(c);
            if(!visited.contains(c) && hasCycle(c)) return false;
            path.remove(c);
        }        
        return true;
    }

    boolean hasCycle(int course){
        visited.add(course);
        if(!preq.containsKey(course)) return false;
        for(int p : preq.get(course)){
            if(path.contains(p)) return true;
            path.add(p);
            if(hasCycle(p)) return true;
            path.remove(p);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(2, new HashSet<Integer>());
        map.get(2).add(2);
        map.computeIfAbsent(2, k -> new HashSet<>()).add(3);
        System.out.println(map.get(2).toString());
    }
}