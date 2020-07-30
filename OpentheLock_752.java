import java.util.*;

public class OpentheLock_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String d : deadends) deads.add(d);
        String start = "0000";
        if(deads.contains(start)) return -1;
        if(target.equals(start)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);

        for(int turns = 1; !q.isEmpty(); turns++){
            for(int i=q.size(); i>0; --i){
                String state = q.poll();
                for(int j=0; j<4; ++j){
                    for(int d = 1; d<=9; d+=8){
                        StringBuilder state1 = new StringBuilder(state);
                        state1.setCharAt(j, (char)((state1.charAt(j)-'0'+d)%10+'0'));
                        String newState = state1.toString();   
                        if(newState.equals(target)) return turns;
                        if(!deads.contains(newState) && !visited.contains(newState)){
                            q.add(newState);
                        }
                        visited.add(newState);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}