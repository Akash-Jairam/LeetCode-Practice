class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean isEven = length % 2 == 0;
        int resultLength = 0;
        String res = "";
        
        for(int i = 0; i < length; ++i){
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > resultLength){
                    res = s.substring(left, right+1);
                    resultLength = right - left + 1;
                }
                --left;
                ++right;
            }
            
            left = i;
            right = i+1;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > resultLength){
                    res = s.substring(left, right+1);
                    resultLength = right - left + 1;
                }
                --left;
                ++right;
            }
        }
        
        return res;
    }
}