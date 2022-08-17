class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> uniqueWords = new HashSet<>();
        
        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()){
                sb.append(morse[c - 'a']);
            }
            uniqueWords.add(sb.toString());
        }
        
        return uniqueWords.size();
    }
}