class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Create a function that iterates through the characters in each string
        // Create a stack which will hold our string
        // We will iterate through each character in the given string
        // If the character is a # we will pop the stack
        // Else we will push the character to the stack
        // We will convert the stack to a string and return it
        // Compare the two returned strings and return the result
        return backspace(s).equals(backspace(t));
    }
    
    public String backspace(String s){
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '#' && !stack.isEmpty())
                stack.pop();
            else if(c != '#')
                stack.push(c);
        }
        System.out.println(String.valueOf(stack));
        return String.valueOf(stack);
    }
}