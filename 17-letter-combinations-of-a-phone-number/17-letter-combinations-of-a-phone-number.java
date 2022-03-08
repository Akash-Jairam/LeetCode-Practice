class Solution {
    public List<String> letterCombinations(String digits) {
        // Create a list to hold our results
        // If the string is empty, return the list
        // Create a map to hold the corresponding letters for each number
        // Call our backtrack function passing the list, the map and digits
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(res, map, digits, new StringBuilder(digits.length()));
        return res;
    }
    
    public void backtrack(List<String> res, Map<Character, String> map , String digits, StringBuilder current){
        if(current.length() == digits.length()){
            res.add(current.toString());
            return;
        }
        
        String curr = map.get(digits.charAt(current.length()));
        for(char c : curr.toCharArray()){
            current.append(c);
            backtrack(res, map, digits, current);
            current.deleteCharAt(current.length()-1);
        }
    }
}