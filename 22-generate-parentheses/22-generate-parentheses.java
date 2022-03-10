class Solution {
    public List<String> generateParenthesis(int n) {
        // Create a list to hold our results
        // If n is less than or equal to zero, just return the list
        // Call our backtrack function while passing our list, n, an empty string, 0, and 0 (the two zeroes represent our open and closed bracket counts, the empty string represents our current string)
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        backtrack(res, n, "", 0, 0);
        return res;
    }
    
    public void backtrack(List<String> res, int n, String curr, int numOpen, int numClosed){
        // Create exit statement
        if(curr.length() == n*2){
            res.add(curr);
            return;
        }
        
        // If the number of open braces are less than n, recurse by adding a brace to the current string and incrementing numOpen
        // If the numberof closed braces is less than num open( we only add closing braces to close open ones), do the same but with a closing brace and incrementing numClosed
        if(numOpen < n){
            backtrack(res, n, curr+"(", numOpen+1, numClosed);}
        if(numClosed < numOpen){
            backtrack(res, n, curr+")", numOpen, numClosed+1);}
    }
}