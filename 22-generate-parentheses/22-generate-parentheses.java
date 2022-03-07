class Solution {
    public List<String> generateParenthesis(int n) {
        // Create a list of strings which will hold our results
        // If n is less than or equal to 0, return the list immediately
        // Call the backtrack function 
        // Return the result
        List<String> result = new ArrayList<>();
        if(n <= 0)
            return result;
        
        backtrack(result, n, "", 0, 0);
        return result;
    }
    
    public void backtrack(List<String> result, int max, String current, int openCount, int closeCount){
        // Exit clause
        if(current.length() == max * 2){
            result.add(current.toString());
            return;
        }
        // Conditionals
        if(openCount < max){
            backtrack(result, max, current + "(", openCount+1, closeCount);
        }
        
        if(closeCount < openCount){
            backtrack(result, max, current + ")", openCount, closeCount+1);
        }
    }
}