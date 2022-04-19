class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        if(s.length() % 2 == 1)
            return false;
        
        
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '(' || c == '[')
                stack.push(c);
            else {
                if(c == ')' && !stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else if(c == ']' && !stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else if(c == '}' && !stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}