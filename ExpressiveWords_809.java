
public class ExpressiveWords_809 {
    public int expressiveWords(String S, String[] words) {
        int ret = 0;
        for(String w:words){
            if(valid(S,w)) ret++;
        }
        return ret;
    }

    boolean valid(String S, String w){
        int i = 0, j = 0, ns = S.length(), nw = w.length();
        while(i<ns && j<nw){
            if(S.charAt(i)!=w.charAt(j)) return false;
            int i1 = i, j1 = j;
            while(i1<ns && S.charAt(i1)==S.charAt(i)) i1++;
            while(j1<nw && w.charAt(j1)==w.charAt(j)) j1++;
            int cntS = i1-i, cntW = j1-j;
            if(cntS<cntW) return false;
            if(cntS>cntW && cntW<3) return false;
            i = i1, j = j1;
        }
        return i==ns && j==nw;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}