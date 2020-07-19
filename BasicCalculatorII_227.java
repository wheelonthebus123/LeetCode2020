import java.util.*;

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
                    case '+': lhs += rhs; prv = rhs; break;
                    case '-': lhs -= rhs; prv = -rhs; break;
                    case '*': lhs -= prv; prv = prv*rhs; lhs += prv; break;   
                    case '/': lhs -= prv; prv = prv/rhs; lhs += prv; break;                        
                    default: break;
                }
                rhs = 0;
                op = c;
            }
            i++;
        }
        return lhs;
    }

    public int calculate1(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int v = 0;
        boolean hasV = false;
        s += '+';

        for(char c:s.toCharArray()){
            if(c==' ') continue;
            else if(Character.isDigit(c)){
                v = v*10 + c - '0';
                hasV = true;
            }else{//'+', '-'
                if(hasV)
                    nums.push(v); v = 0; hasV = false;
                while(!ops.empty() && precedence(ops.peek())>=precedence(c))
                    evaluate(nums, ops);
                ops.push(c);
            }
        }

        return nums.pop();
    }

    int precedence(char op){
        switch(op){
            case '+' : return 0;
            case '-' : return 0;
            case '*' : return 1;
            case '/' : return 1;
            default: return -2;
        }
    }

    void evaluate(Stack<Integer> nums, Stack<Character> ops){
        int r = nums.pop();
        int l = nums.pop();
        char op = ops.pop();
        int result = 0;
        switch (op)
        {
            case '+' : result = l+r; break;
            case '-' : result = l-r; break;
            case '*' : result = l*r; break;
            case '/' : result = l/r; break;
            default: break;
        }
        nums.push(result);
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        BasicCalculatorII_227 sol = new BasicCalculatorII_227();
        int ret = sol.calculate1(" 3+5 / 2 ");
        System.out.println(ret);
    }
}