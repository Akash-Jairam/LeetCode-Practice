class Solution {
    public boolean validPalindrome(String s) {
        // For a string to be a palindrome, the characters diverging from the midpoint should be equal to each other
        // Therefore, we should set pointers at the beginning and end and move inwards until we encounter two characters that are not equal to each other
        // Perform a check to see if removing either of those characters results in a palindrome
        // if true, return true
        // Return false at the end
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return (isPalindrome(s.substring(0, start) + s.substring(start+1)) || isPalindrome(s.substring(0, end) + (end == s.length() -1 ? "" : s.substring(end+1))));
            }
            --end;
            ++start;
        }
        
        return true;
    }
    
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s.length());
        
        for(int i = s.length()-1; i >= 0; --i){
            sb.append(s.charAt(i));
        }
        
        return sb.toString().equals(s);
    }
}