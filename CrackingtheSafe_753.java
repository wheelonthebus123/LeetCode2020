import java.util.*;

public class CrackingtheSafe_753 {
    public String crackSafe(int n, int k) {
        StringBuilder pwd = new StringBuilder(new String(new char[n]).replace('\0', '0'));
        int total = (int)Math.pow(k, n);
        Set<String> visited = new HashSet<>();
        visited.add(pwd.toString());
        helper(pwd, total, visited, n, k);
        return pwd.toString();
    }

    boolean helper(StringBuilder pwd, int total, Set<String> visited, int n, int k){
        if(visited.size() == total) return true;
        String surfix = pwd.substring(pwd.length()-n+1);
        for(char c = '0'; c<'0'+k; c++){
            String surfix1 = surfix + c;
            if(!visited.contains(surfix1)){
                pwd.append(c);
                visited.add(surfix1);
                if(helper(pwd, total, visited, n, k)) return true;
                visited.remove(surfix1);
                pwd.deleteCharAt(pwd.length()-1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}