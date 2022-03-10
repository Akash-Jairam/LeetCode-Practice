class Solution {
    public List<String> letterCombinations(String digits) {
        // Create a list to hold our results
        // iF the string is empty, return our list
        // Call our backtrack function with our string, our list and an empty string
        // Create an initialize a map to hold the letters for each digit
        // Return list
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())
            return res;
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(res, digits, new StringBuilder(digits.length()), map);
        return res;
    }
    
    public void backtrack(List<String> res, String digits, StringBuilder curr, Map<Character, String> map){
        if(curr.length() == digits.length()){
            res.add(curr.toString());
            return;
        }
        
        for(char c : map.get(digits.charAt(curr.length())).toCharArray()){
            curr.append(String.valueOf(c));
            backtrack(res, digits, curr, map);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}