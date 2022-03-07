class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        
        Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(new StringBuilder(digits.length()), result, 0, digits, letters);
        return result;
    }
    
    public void backtrack(StringBuilder curr, List<String> result, int index, String digits, Map<Character, String> letters){
        if(curr.length() == digits.length()){
            result.add(curr.toString());
            return;
        }
        
        String currCombo = letters.get(digits.charAt(index));
        for(char c : currCombo.toCharArray()){
            curr.append(c);
            backtrack(curr, result, index+1, digits, letters);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}