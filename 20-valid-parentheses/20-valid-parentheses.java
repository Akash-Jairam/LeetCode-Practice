class Solution {
    public boolean isValid(String s) {
        // Create a stack that will hold our open braces
        // Iterate through s to char array
        // If we encounter an opening brace, we push to the stack
        // Else, if the closing brace is equal to the element at the top of the stack, we pop it
        // Else, push it to the stack
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if( c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else if( c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else if( c == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else
                stack.push(c);
        }
        
        return stack.isEmpty();
    }
}