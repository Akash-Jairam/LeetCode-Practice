class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        
        Stack<Character> stack = new Stack<Character>();
        int stringLength = s.length()-1;
        
     
        
        for(int i = 0; i <= stringLength; i++){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{')
                stack.push(temp);
            else{
                switch(temp){
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(')
                            stack.pop();
                        else{
                            stack.push(temp);
                        }
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[')
                            stack.pop();
                        else
                            stack.push(temp);
                        break;
                    case '}':
                        if(!stack.isEmpty() && stack.peek() == '{')
                            stack.pop();
                        else
                            stack.push(temp);
                        break;
                }
            }
        }  
        
        return stack.isEmpty();
    }
}