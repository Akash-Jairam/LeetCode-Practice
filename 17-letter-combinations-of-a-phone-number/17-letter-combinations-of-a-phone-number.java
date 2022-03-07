class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        Map<Character, String> map =  Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        // Create a map to map the digits to a character
        // Call our backtrack function, passing the map, the string, the result, and a stringbuilder
        backtrack(map, digits, result, new StringBuilder(), 0);
        return result;
    }
    
    public void backtrack(Map<Character, String> map, String digits, List<String> result, StringBuilder current, int index){
        if(current.length() == digits.length()){
            result.add(current.toString());
            return;
        }
        
        String curr = map.get(digits.charAt(index));
        
        for(char c : curr.toCharArray()){
            current.append(String.valueOf(c));
            backtrack(map, digits, result, current, index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}