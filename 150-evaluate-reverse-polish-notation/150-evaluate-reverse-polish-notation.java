class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String s : tokens){
            if(s.length() > 1){
                stack.push(Integer.parseInt(s));
            } else{
                Character c = s.charAt(0);
                if(Character.isDigit(c)){
                    stack.push(c - '0');
                } else {
                    int second = stack.pop();
                    int first = stack.pop();
                    if(c == '+')
                        stack.push(first + second);
                    else if(c == '-')
                        stack.push(first - second);
                    else if( c == '*')
                        stack.push(first * second);
                    else{
                        stack.push(first / second);
                    }
                }
            }
        }
        
        return stack.peek();
    }
}