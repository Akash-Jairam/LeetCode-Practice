class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // Create a list to hold our results
        // Call our function
        // return result
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, '(', ')');
        return res;
    }
    
    public void remove(String s, List<String> res, int iStart, int jStart, char open, char closed){
        int openCount = 0, closedCount = 0;
        // Iterate through string starting from i start
        // Check to see if the current char is an open brace or a closed brace and increment the appropriate variable
        // If the closedCount is greater than the open count
        // Iterate through the string starting from the j count and ending at the icount
        // If the current character at the jth index is a closed brace and j is either at the jstart position or the previous character is not an open brace
        // This means that we have found the extra closed brace
        // Make a recursive call to our remove method but this time, pass in the string without the extra brace and the j start and i start variables
        // Add a return statement at the end of the for loop since the recursion will handle everything else
        // Reverse the string and if the open brace var == (, call the function again but swap the open and closed braces (to search for extra open braces)
        // Else add to result
        for(int i = iStart; i < s.length(); ++i){
            if(s.charAt(i) == open) ++openCount;
            if(s.charAt(i) == closed) ++closedCount;
            
            if(closedCount > openCount){
                for(int j = jStart; j <= i; ++j){
                    if(s.charAt(j) == closed && (j == jStart || s.charAt(j-1) != closed)){
                        remove(s.substring(0, j) + s.substring(j+1), res,i, j, open, closed);
                    }
                    
                }
                return;
            }
            
        }
        
            String reversed = new StringBuilder(s).reverse().toString();
            if(open == '(')
                remove(reversed, res, 0, 0, ')', '(');
            else
                res.add(reversed);
    }
}