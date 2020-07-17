import java.util.*;

public class BasicCalculator_224 {
    public int calculate(String s) {
        Stack<Integer> lshs = new Stack<>();
        Stack<Integer> ops = new Stack<>();
        int lhs = 0, rhs = 0, op = 1;
        s += '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                rhs = rhs * 10 + (c - '0');
            }else if (c=='+') {
                lhs += rhs*op;
                rhs = 0;
                op = 1;
            }else if (c=='-') {
                lhs += rhs*op;
                rhs = 0;
                op = -1;
            }else if (c == '('){
                lshs.push(lhs);
                lhs = 0;
                ops.push(op);
                op = 1;
            }else if (c == ')'){
                lhs += rhs*op;
                rhs = 0;
                op = 1;
                lhs = lshs.pop() + lhs * ops.pop();
            }
        }
        return lhs;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        BasicCalculator_224 sol = new BasicCalculator_224();
        int ret = sol.calculate("9-(3-1)");
        System.out.println("the result is " + ret);
    }
}