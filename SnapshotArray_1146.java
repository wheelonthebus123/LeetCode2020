import java.util.*;

public class SnapshotArray_1146 {
    TreeMap<Integer, Integer>[] ss;
    int snap_id = 0;
    public SnapshotArray_1146(int length) {
        ss = new TreeMap[length];
        for(int i=0; i<length; ++i)
        {
            ss[i] = new TreeMap<Integer, Integer>();
            ss[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        ss[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return ss[index].floorEntry(snap_id).getValue();
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}