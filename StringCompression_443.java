public class StringCompression_443 {
    public int compress(char[] chars) {
        int n = chars.length;
        int ret = 0;
        int i = 0;
        while(i<n){
            int j = i;
            while(j<n && chars[i]==chars[j]) j++;
            int count = j-i;
            chars[++ret] = chars[i];
            if(count>1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[++ret] = c;
                }
            }
            i = j;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        StringCompression_443 sol = new StringCompression_443();
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        sol.compress(chars);
    }
}