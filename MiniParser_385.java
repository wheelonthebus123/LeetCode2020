/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
1. What is the invariant?
 -- The top of stack should be the answer
2. What are the rules?
 -- A number makes a NestedInteger node 
 -- A pair of [] makes a NestedInteger list
3. What is the strategy?
 -- Each element of stack is a NestedInteger list 
4. What is the special case?
 -- If there is only one number in the string, the stack top is a NestedInteger node
5. How to approach?
 -- Whenever see '[', we create a new NestedInteger list and push to the stack
 -- Whenever see ']', we complete a NestedInteger list. 
    ----If the stack is empty, the completed NestedInteger list is our answer so we push it back to the stack.
    ----Otherwise, the completed NestedInteger is part of an unfinished list, which is also the top of the stack. So we add it to the stack's top element. 

class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stk = new Stack();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c) || c=='-'){
                int j = i;
                while(j<s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j)=='-')) j++;
                String num = s.substring(i, j);
                NestedInteger node = new NestedInteger(Integer.valueOf(num));
                if(stk.empty()) 
                    stk.push(node);
                else{
                    NestedInteger top = stk.peek();
                    top.add(node);
                }
                i = j;
            }else if(c == '['){
                stk.push(new NestedInteger());
                i++;
            }else if(c == ','){
                i++;
            }else if(c == ']'){
                NestedInteger complete = stk.pop();
                if(!stk.empty()){
                    stk.peek().add(complete);
                }else{
                    stk.push(complete);
                }
                i++;
            }
        }
        
        if(stk.empty()) return null;
        else return stk.pop();
    }
}
*/