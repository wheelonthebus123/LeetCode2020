public class BasicCalculatorII_227 {
    public int calculate(String s) {
        int lhs = 0, rhs = 0, prv = 0, i = 0;
        char op = '+';
        s += '+';

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                rhs = rhs * 10 + (c - '0');
            } else if(c!=' '){// +-*/
                switch (op) {
                    case '+': {
                        lhs += rhs;
                        prv = rhs;
                        break;
                    }
                    case '-': {
                        lhs -= rhs;
                        prv = -rhs;
                        break;
                    }
                    case '*': {
                        lhs -= prv;
                        prv = prv*rhs;
                        lhs += prv;
                        break;
                    }
                    case '/': {
                        lhs -= prv;
                        prv = prv/rhs;
                        lhs += prv;
                        break;                        
                    }
                    default:
                        break;
                }
                rhs = 0;
                op = c;
            }
            i++;
        }
        return lhs;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        BasicCalculatorII_227 sol = new BasicCalculatorII_227();
        int ret = sol.calculate("7+ 8 8 ");
        System.out.println(ret);
    }
}