class Solution {
    public boolean backspaceCompare(String s, String t) {
        return cleanString(s).equals(cleanString(t));
    }
    
    public String cleanString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) != '#')
                stack.push(s.charAt(i));
            else if(!stack.isEmpty())
                stack.pop();
        }
        
        return String.valueOf(stack);
    }
}