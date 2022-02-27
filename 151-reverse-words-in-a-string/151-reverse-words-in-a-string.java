class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
    
        for(int i = words.length-1; i >=0; --i){
            if(!words[i].equals("")){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}