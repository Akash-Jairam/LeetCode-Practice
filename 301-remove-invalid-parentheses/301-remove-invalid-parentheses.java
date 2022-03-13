class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // Create a list of strings to hold our result
        // Call our method
        // Return result
        List<String> res = new ArrayList<>();
        removeHelper(s, res, 0, 0, '(', ')');
        return res;
    }
    
    public void removeHelper(String s, List<String> res, int iStart, int jStart, char open, char closed){
        int numOpen = 0,  numClosed = 0;
        
        for(int i = iStart; i < s.length(); ++i){
            if(s.charAt(i) == open) ++numOpen;
            if(s.charAt(i) == closed) ++numClosed;
            
            if(numClosed > numOpen){
                for(int j = jStart; j <= i; ++j){
                    if(s.charAt(j) == closed && (j == jStart || s.charAt(j-1) != closed)){
                        removeHelper(s.substring(0, j) + s.substring(j+1), res, i, j, open, closed);
                    }
                }
                return;
            }
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if(open == '('){
            removeHelper(reversed, res, 0, 0, ')', '(');
        } else
            res.add(reversed);
    }
}