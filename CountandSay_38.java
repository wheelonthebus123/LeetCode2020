public class CountandSay_38 {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder cur = new StringBuilder();
        int i = 0, sz = prev.length();
        while(i<sz){
            char c = prev.charAt(i++);
            int count = 1;
            while(i<sz && prev.charAt(i)==c){
                count++;
                i++;
            }
            cur.append(count);
            cur.append(c);
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        CountandSay_38 sol = new CountandSay_38();
        sol.countAndSay(4);
    }
}