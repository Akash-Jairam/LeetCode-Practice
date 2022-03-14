class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty() || digits.isBlank())
            return res;
        Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        backtrack(res, digits, "", map, 0);
        return res;
    }
    
    public void backtrack(List<String> res, String digits, String current, Map<Character, String> map, int index){
        if(current.length() == digits.length()){
            res.add(current);
            return;
        }
        
        
            String curr = map.get(digits.charAt(index));
            for(char c : curr.toCharArray()){
            current += String.valueOf(c);
            backtrack(res, digits, current, map, index + 1);
            current = current.substring(0, current.length()-1);
            }
        
    }
}