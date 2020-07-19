import java.util.*;
public class BasicCalculatorIII_772 {
    public int calculate(String s) {
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
                ops.pop();             
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
        BasicCalculatorIII_772 sol = new BasicCalculatorIII_772();
        sol.calculate("2*(5+5*2)/3+(6/2+8)");
    }
}