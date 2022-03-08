class Solution {
    public List<String> generateParenthesis(int n) {
        // Create our list that will hold our parenthesis
        // If n is less than or equal to zero, return our list
        // Call our backtrack function passing in our list, an empty string, 0, 0 and n (the two zeros are for the number of open brackets and the number of closing brackets)
        // Return our list
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backtrack(List<String> result, String curr, int numOpen, int numClose, int n){
        // If the length of the current string is equal to n times 2
        // Add the current string to the list and add it to our result before returning
        
        // If the number of open braces is less than n, we append an open brace to our current string and make a recursive call, making sure to increment the number of open braces we are sending in the parameter
        
        // If the number of closed braces is less than the number of open braces, we do the same as before but with a closed brace and incremementing the closed braces count
        if(curr.length() == n * 2){
            result.add(curr);
            return;
        }
        
        if(numOpen < n){
            backtrack(result, curr+"(", numOpen+1, numClose, n);
        }
        
        if(numClose < numOpen){
            backtrack(result, curr+")", numOpen, numClose+1, n);
        }
    }
}