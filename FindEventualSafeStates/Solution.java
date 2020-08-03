package FindEventualSafeStates;

import java.util.*;
public class Solution {
    int n;
    boolean[] visited = new boolean[10000];
    boolean[] path = new boolean[10000];
    List<Integer> ret = new ArrayList<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        for(int node = 0; node<n; ++node){
            visited = new boolean[10000];
            path[node] = true;
            if(!hasCycle(node, graph)){
                ret.add(node);
            }
            path[node] = false;
        }
        return ret;
    }

    boolean hasCycle(int node, int[][] graph){
        visited[node] = true;
        for(int next:graph[node]){
            if(path[next]) return true;
            path[next] = true;
            if(!visited[next] && hasCycle(next, graph)) return true;
            path[next] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] graph = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        sol.eventualSafeNodes(graph);
    }
}