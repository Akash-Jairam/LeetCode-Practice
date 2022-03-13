class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        removeHelper(s, res, 0, 0, '(', ')');
        return res;
    }
    
    public void removeHelper(String s, List<String> res, int iStart, int jStart, char openParen, char closedParen ){
        int numOpenParen = 0, numClosedParen = 0;
        for(int i = iStart; i < s.length(); ++i){
            if(s.charAt(i) == openParen) ++numOpenParen;
            if(s.charAt(i) == closedParen) ++numClosedParen;
            
            if(numClosedParen > numOpenParen){
                for(int j = jStart; j <= i; ++j){
                    if(s.charAt(j) == closedParen && (j == jStart || s.charAt(j-1) != closedParen)){
                        removeHelper(s.substring(0, j) + s.substring(j+1), res, i, j, openParen, closedParen);
                    } 
                    
                }
                return;
            }
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParen == '(')
            removeHelper(reversed, res, 0, 0, ')', '(');
        else
            res.add(reversed);
    }
}