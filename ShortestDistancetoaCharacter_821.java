public class ShortestDistancetoaCharacter_821 {
    public int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] ret = new int[len];

        int e = -1;
        for(int i=0; i<len; ++i)
        {
            if(S.charAt(i)==C) e = i;
            if(e==-1) ret[i] = len;
            else ret[i] = i-e;
        }

        e = len;
        for(int i=len-1; i>=0; --i)
        {
            if(S.charAt(i)==C) e = i;
            if(e<len) ret[i] = Math.min(ret[i], e-i);
        }

        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}