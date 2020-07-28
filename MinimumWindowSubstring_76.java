public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int l = 0, r = 0;
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        for(char c : t.toCharArray()) cntT[c]++ ;

        int cnt = 0;//effective length
        String ret = new String();
        while(r < m){
            char cr = s.charAt(r);
            cntS[cr]++;
            if(cntS[cr] <= cntT[cr]){
                cnt++;
                while(cnt == n){
                    char cl = s.charAt(l);
                    cntS[cl]--;
                    if(cntS[cl] < cntT[cl]){
                        cnt--;
                        if(ret.length()==0 || ret.length()>r-l+1)
                            ret = s.substring(l, r+1);
                    }
                    l++;
                }
            }
            r++;
        }

        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}