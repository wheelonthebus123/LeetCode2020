package InsertDeleteGetRandom_DuplicatesAllowed_381;
import java.util.*;

public class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer, LinkedHashSet<Integer>> valToInd;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        valToInd = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = valToInd.containsKey(val);
        if(!contains) valToInd.put(val, new LinkedHashSet<Integer>());
        valToInd.get(val).add(list.size());
        list.add(val);
        System.out.println(list.toString());
        printMap();
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!valToInd.containsKey(val)) return false;
        int iEnd = list.size()-1;
        int vEnd = list.get(iEnd);
        int iToBeRemoved;
        if(val==vEnd)
        {
            iToBeRemoved = iEnd;
        }else{
            iToBeRemoved = valToInd.get(val).iterator().next();
            Collections.swap(list, iToBeRemoved, iEnd);
            valToInd.get(vEnd).remove(iEnd);
            valToInd.get(vEnd).add(iToBeRemoved);  
        }
        valToInd.get(val).remove(iToBeRemoved);
        list.remove(iEnd);
            
        if(valToInd.get(val).size()==0) 
            valToInd.remove(val);
        System.out.println(list.toString());
        printMap();
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        System.out.println(list.toString());
        return list.get((int) (Math.random()*list.size()));
    }
    
    public void printMap() {
        for(Map.Entry e : valToInd.entrySet())
        {
            System.out.print(e.getKey() + " " + e.getValue().toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}