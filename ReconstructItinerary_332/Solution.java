package ReconstructItinerary_332;

import java.util.*;

public class Solution {
    List<String> routes;   
    Map<String, PriorityQueue<String>> flights; 
    public List<String> findItinerary(List<List<String>> tickets) {
        routes = new ArrayList<>();
        flights = new HashMap<>();
        for(List<String> t : tickets){
            String src = t.get(0);
            String dst = t.get(1);
            flights.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }
        helper("JFK");
        return routes;
    }

    void helper(String airport){
        while(flights.containsKey(airport) && !flights.get(airport).isEmpty()){
            helper(flights.get(airport).poll());
        }
        routes.add(0, airport);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(9);
        pq.add(8);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}