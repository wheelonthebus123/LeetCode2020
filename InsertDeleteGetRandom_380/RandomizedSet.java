package InsertDeleteGetRandom_380;

import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToInd.containsKey(val)) return false;
        int index = valToInd.get(val);
        int iEnd = list.size()-1;
        int vEnd = list.get(iEnd);
        Collections.swap(list, index, iEnd);
        valToInd.put(vEnd,index);
        list.remove(iEnd);
        valToInd.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int) (Math.random()*list.size()));
    }
    
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}