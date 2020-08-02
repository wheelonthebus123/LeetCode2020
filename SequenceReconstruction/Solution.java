package SequenceReconstruction;
import java.util.*;

public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> links = new HashMap<>();
        Map<Integer, Integer> degrees = new HashMap<>();

        for(List<Integer> s : seqs){
            for(int i = 0; i<s.size(); ++i){
                degrees.computeIfAbsent(s.get(i), k -> 0);
                links.computeIfAbsent(s.get(i), k -> new HashSet<>());
                if(i<s.size()-1){
                    degrees.computeIfAbsent(s.get(i+1), k -> 0);
                    if(!links.get(s.get(i)).contains(s.get(i+1))){
                        links.get(s.get(i)).add(s.get(i+1));
                        degrees.compute(s.get(i+1), (k,v) -> v=v+1);
                    }
                }
            }
        }
        if(links.size()!=org.length) return false;

        Queue<Integer> que = new LinkedList<>();
        for(Map.Entry<Integer, Integer> e : degrees.entrySet()){
            if(e.getValue()==0) que.offer(e.getKey());
        }

        int index = 0;
        while(!que.isEmpty()){
            if(que.size()>1) return false;
            int top = que.poll();
            if(index==org.length || top!=org[index++]) return false;
            for(int next : links.get(top)){
                degrees.compute(next, (k,v)->v=v-1);
                if(degrees.get(next)==0) que.offer(next);
            }
        }

        return index == org.length;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        int[] org = new int[]{4,1,5,2,6,3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(5,2,6,3));
        seqs.add(Arrays.asList(4,1,5,2));
        Solution sol = new Solution();
        sol.sequenceReconstruction(org, seqs);
    }
}