import java.util.*;

public class BasicCalculator_224 {
    public int calculate(String s) {
        Stack<Integer> lshs = new Stack<>();
        Stack<Integer> ops = new Stack<>();
        int lhs = 0, rhs = 0, op = 1;

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
            }else if(c=='('){
                ops.push(c);
            }else if(c==')'){
                if(hasV)
                    nums.push(v); v = 0; hasV = false;
                while(!ops.empty() && ops.peek()!='(')
                    evaluate(nums, ops);
                ops.pop();//pop '('
            }else{//'+', '-'
                if(hasV)
                    nums.push(v); v = 0; hasV = false;
                if(!ops.empty() && precedence(ops.peek())>=precedence(c))
                    evaluate(nums, ops);
                ops.push(c);
            }
        }

        return nums.pop();
    }

    int precedence(char op){
        switch(op){
            case '(' : return -1;
            case '+' : return 0;
            case '-' : return 0;
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
            default: break;
        }
        nums.push(result);
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        BasicCalculator_224 sol = new BasicCalculator_224();
        int ret = sol.calculate1("(1+(4+5+2)-3)+(6+8)");
        System.out.println("the result is " + ret);
    }
}