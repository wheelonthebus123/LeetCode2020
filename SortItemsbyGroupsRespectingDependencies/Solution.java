package SortItemsbyGroupsRespectingDependencies;

import java.util.*;
public class Solution {
    Map<Integer, Set<Integer>> links = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> path = new HashSet<>();
    List<Integer> ret = new ArrayList<>();
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0; i<n+2*m; ++i){
            links.computeIfAbsent(i, k->new HashSet<>());
        }

        //build group boundaries
        for(int i=0; i<n; ++i){
            if(group[i]>=0){
                int lowerBoundNodeOfGroupI = n + group[i];
                int uppperBoundNodeOfGroupI = n + m + group[i];
                links.get(lowerBoundNodeOfGroupI).add(i);
                links.get(i).add(uppperBoundNodeOfGroupI);
            }
        }

        //connect them
        for(int b=0; b<n; ++b){
        for(int a : beforeItems.get(b)){
            //a -> b
            //a's upper bound is n+m+group[a]
            //b's lower bound is n+group[b]
            if(group[a]==-1 && group[b]==-1){
                links.get(a).add(b);
            }else if(group[a]!=-1 && group[b]!=-1){
                if(group[a]==group[b]){//inner group
                    links.get(a).add(b);
                }else{//intra group
                    links.get(n+m+group[a]).add(n+group[b]);
                }
            }else{
                if(group[a]==-1){//a is not in any group
                    links.get(a).add(n+group[b]);
                }else{//b is not is any group
                    links.get(n+m+group[a]).add(b);
                }
            }
        }
        }

        for(int i=0; i<n+2*m; ++i){
            if(!visited.contains(i)){
                path.add(i);
                if(hasCycle(i)) return new int[0];
                path.remove(i);
            }
        }

        int[] retarr = new int[n];
        int index = 0;
        for(int i=0; i<n; i++){
            while(ret.get(index)>=n) index++;
            retarr[i] = ret.get(index++);
        }       
        return retarr;
    }

    boolean hasCycle(int node){
        visited.add(node);
        if(links.containsKey(node)){
            for(int next : links.get(node)){
                if(path.contains(next)) return true;
                path.add(next);
                if(!visited.contains(next) && hasCycle(next)) return true;
                path.remove(next);
            }
        }
        ret.add(0, node);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        int[] group = new int[]{-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(new ArrayList<>());
        beforeItems.add(Arrays.asList(new Integer[]{6}));
        beforeItems.add(Arrays.asList(new Integer[]{5}));
        beforeItems.add(Arrays.asList(new Integer[]{6}));
        beforeItems.add(Arrays.asList(new Integer[]{3,6}));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        Solution sol = new Solution();
        sol.sortItems(8, 2, group, beforeItems);
    }
}