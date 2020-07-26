public class LongPressedName_925 {
    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0, p2 = 0, n1 = name.length(), n2 = typed.length();
        while(p1<n1 && p2<n2){
            if(name.charAt(p1)!=typed.charAt(p2)) return false;
            int q1 = p1+1, q2 = p2+1;
            while(q1<n1 && name.charAt(q1)==name.charAt(p1)) q1++;
            while(q2<n2 && typed.charAt(q2)==typed.charAt(p2)) q2++;
            int c1 = q1-p1;
            int c2 = q2-p2;
            if(c2<c1) return false;
            p1 = q1;
            p2 = q2;
        }
        return p1==n1 && p2==n2;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        LongPressedName_925 sol  = new LongPressedName_925();
        sol.isLongPressedName("alex", "aaleex");
    }
}