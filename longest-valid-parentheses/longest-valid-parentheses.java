class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty() || s.isBlank())
            return 0;
        
        int numOpen = 0, numClosed = 0;
        int max = 0;
        
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(')
                ++numOpen;
            else if(s.charAt(i) == ')')
                ++numClosed;
            
            if(numClosed == numOpen){
                max = Math.max(max, numClosed * 2);
            } else if(numClosed >= numOpen){
                numClosed = 0;
                numOpen = 0;
            }
        }
        
        numOpen = 0; numClosed = 0;
        
        for(int i = s.length()-1; i >= 0; --i){
            if(s.charAt(i) == '(')
                ++numOpen;
            else if(s.charAt(i) == ')')
                ++numClosed;
            
            if(numOpen == numClosed){
                max = Math.max(max, numOpen * 2);
            } else if(numOpen >= numClosed){
                numOpen = 0;
                numClosed = 0;
            }
        }
        
        return max;
    }
}