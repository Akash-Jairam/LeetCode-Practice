class Solution {
    public List<String> letterCombinations(String digits) {
        // Create a hashmap to map each digit to it's corresponding string
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        // Create a list to hold our results
        List<String> res = new ArrayList<>();
        // Do obligaotry null check
        if(digits.isBlank() || digits.isEmpty())
            return res;
        // Make a call to our backtracking function and pass in the map, the given string and our list     
        backtrack(digits, map, res, new StringBuilder(), 0);
        return res;
    }
    
    public void backtrack(String digits, Map<Character, String> map, List<String> res, StringBuilder sb, int index){
        // Do base case to define return conditions. If sb.length = digits.length, add a copy of it to our result and return or return if index > digits.legnth -1
        if(sb.length() == digits.length() || index > digits.length()-1){
            res.add(sb.toString());
            return;
        }
        // Iterate throguh the characters from the given index, make a recursive cal and remove the character afterwards
        String curr = map.get(digits.charAt(index));
        
        for(char c : curr.toCharArray()){
            sb.append(c);
            backtrack(digits, map, res, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}