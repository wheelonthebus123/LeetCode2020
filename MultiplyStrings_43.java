public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if(num1.length() < num2.length()){
            return multiply(num2, num1);
        }
        StringBuilder ret = new StringBuilder();
        for(int i=num2.length()-1; i>=0; --i){
            ret = add(ret, multiply1(num1, num2.charAt(i), num2.length()-1-i));
        }
        
        int i=0;
        while(i<ret.length()-1 && ret.charAt(i)=='0') i++;
        return ret.substring(i);
    }

    StringBuilder add(StringBuilder num1, StringBuilder num2){
        StringBuilder ret = new StringBuilder();
        num1.reverse();
        num2.reverse();
        int i = 0, j = 0, c = 0;
        while(i<num1.length() || j<num2.length()){
            if(i<num1.length()) c += num1.charAt(i++) - '0';
            if(j<num2.length()) c += num2.charAt(j++) - '0';
            ret.append(c%10);
            c = c/10;
        }
        if(c>0){
            ret.append(c);
        }
        return ret.reverse();
    }

    StringBuilder multiply1(String a, char b, int offset){
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for(int i=a.length()-1; i>=0; --i){
            c += (a.charAt(i) - '0')*(b-'0');
            sb.append(c%10);
            c = c/10;
        }
        if(c!=0){
            sb.append(c);
        }
        sb.reverse();
        for(int i=0; i<offset; ++i){
            sb.append(0);
        }
        return sb;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
        MultiplyStrings_43 sol = new MultiplyStrings_43();
        sol.multiply("2", "3");
    }
}