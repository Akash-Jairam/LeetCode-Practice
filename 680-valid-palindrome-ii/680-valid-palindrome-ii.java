class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                StringBuilder sb = new StringBuilder(s);
                if(removeAndCheck(new StringBuilder(s), start) || removeAndCheck(new StringBuilder(s), end))
                    return true;
                else return false;
            }
            ++start;
            --end;
        }
        
        return true;
    }
    
    public boolean removeAndCheck(StringBuilder sb, int pos){
        sb.deleteCharAt(pos);
        return sb.toString().equals(sb.reverse().toString());
    }
    
    
    
}