class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty() || s.isBlank())
            return 0;
        
        int numOpen = 0;
        int numClosed = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(') ++numOpen;
            if(s.charAt(i) == ')') ++numClosed;
            
            if(numOpen == numClosed){
                max = Math.max(numOpen + numClosed, max);
            } else if(numClosed >= numOpen){
                numOpen = 0;
                numClosed = 0;
            }
        }   
        
        numOpen = 0;
                numClosed = 0;
        
        for(int i = s.length()-1; i >= 0; --i){
            if(s.charAt(i) == '(') ++numOpen;
            if(s.charAt(i) == ')') ++numClosed;
            
            if(numOpen == numClosed){
                max = Math.max(numOpen + numClosed, max);
            } else if(numOpen >= numClosed){
                numOpen = 0;
                numClosed = 0;
            }
        }
        
        return max;
    }
}