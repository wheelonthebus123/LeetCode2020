package AlienDictionary_269;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    Map<Character, Set<Character>> links = new HashMap<>();
    public String alienOrder(String[] words) {
        int i = 0;
        boolean cont = true;

        while(cont)
        {
            String prefix0 = "";
            char pChar = '.';
            cont = false;
            for(String w : words)
            {
                if(w.length() < i) continue; //"er**", if i = 3 skip
                String prefix = w.substring(0, i);
                if(w.length() >= i+1)
                {
                    cont = true;
                    char c =  w.charAt(i);
                    if(!links.containsKey(c)) links.put(c, new HashSet<>());
                    if(prefix.equals(prefix0) && pChar!='.' && pChar != c)
                        links.get(pChar).add(c);
                    pChar = c;
                }else{//w.length() == i
                    // for case "abc","ab"
                    if(prefix.equals(prefix0) && pChar != '.') return "";
                }
                prefix0 = prefix;
            }
            i++;
        }

        Set<Character> visited = new HashSet<Character>();
        Set<Character> path = new HashSet<Character>();
        List<Character> seq = new ArrayList<Character>();

        for(Map.Entry e : links.entrySet())
        {
            char node = (char) e.getKey();
            if(!visited.contains(node))
            {
                path.add(node);
                if(hasCycle(visited, path, seq, node)) return "";
                path.remove(node);
            }
        }

        Collections.reverse(seq);
        return seq.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    boolean hasCycle(Set<Character> visited, Set<Character> path, List<Character> seq, char c)
    {
        visited.add(c);
        for(char next : links.get(c))
        {
            if(path.contains(next)) return true;
            if(visited.contains(next)) continue;
            path.add(next);
            if(links.containsKey(next) && hasCycle(visited, path, seq, next)) return true;
            path.remove(next);
        }
        seq.add(c);
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //String r = sol.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        String r = sol.alienOrder(new String[]{"z","z"});
        System.out.println(r);
        /*
        Set<Character> mySet = new HashSet<Character>();
        mySet.addAll(Arrays.asList(new Character[] {'b'}));
        sol.links.put('a', mySet);

        Set<Character> mySet1 = new HashSet<Character>();
        mySet1.addAll(Arrays.asList(new Character[] {'a'}));
        sol.links.put('b', mySet1);

        Set<Character> visited = new HashSet<Character>();
        Set<Character> path = new HashSet<Character>();
        List<Character> seq = new ArrayList<Character>();

        path.add('a');
        boolean r = sol.hasCycle(visited, path, seq, 'a');
        path.remove('a');
        System.out.println("Hi " + r);
        */
    }
}