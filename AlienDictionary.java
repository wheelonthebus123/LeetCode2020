import java.util.*;
import java.util.stream.*;


public class AlienDictionary {
    Map<Character, Set<Character>> links = new HashMap<>();

    public String alienOrder(String[] words) {
        int i = 0;
        boolean cont = true;
        while(cont)
        {
            char pChar = '.';
            String prefix0 = "";
            cont = false;
            
            for(String w : words)
            {
                if(w.length()>=i+1) cont = true;
                String prefix = w.length()<i ? "" : w.substring(0, i);
                if(w.length()<i+1){
                    if(prefix.equals(prefix0) && pChar != '.') return "";
                    continue;
                }
                char c = w.charAt(i);
                if(!links.containsKey(c))
                    links.put(c, new HashSet<>());
                

                if(prefix.equals(prefix0) && pChar != '.' && pChar != c)
                {
                    links.get(pChar).add(c);
                }
                prefix0 = prefix;
                pChar = c;
            }
            i++;
        }

        Set<Character> visited = new HashSet<Character>();
        List<Character> seq = new ArrayList<Character>();
        Set<Character> path = new HashSet<Character>();

        for(Map.Entry e : links.entrySet())
        {
            char c = (char) e.getKey();
            
            if(!visited.contains(c))
            {
                path.add(c);
                if(hasCycle(path, visited, seq, c)) return "";
                path.remove(c);
            }
        }

        Collections.reverse(seq);
        return seq.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public boolean hasCycle (Set<Character> path, Set<Character> visited, List<Character> seq, char c) {
        visited.add(c);
        for(char next : links.get(c))
        {
            if(path.contains(next)) return true;
            if(visited.contains(next)) continue;
            path.add(next);
            if(links.containsKey(next) && hasCycle(path, visited, seq, next)) return true;
            path.remove(next);
        }
        seq.add(c);
        return false;
    }
/*
    public static void main(String[] args) {
        String[] words = new String[] {"abc", "ab"};
        String ret = alienOrder(words);
        System.out.println(ret);
    }
    */
}