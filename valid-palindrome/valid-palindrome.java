class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(Character.toLowerCase(c));
        }
        
        if(sb.length() == 0)
            return true;
        
        return sb.toString().equals(sb.reverse().toString());
    }
}