class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                StringBuilder sb = new StringBuilder(s);
                if(removeAndCheck(new StringBuilder(s.substring(0, start) + s.substring(start+1))) || removeAndCheck(new StringBuilder(s.substring(0, end) + s.substring(end+1))))
                    return true;
                else return false;
            }
            ++start;
            --end;
        }
        
        return true;
    }
    
    public boolean removeAndCheck(StringBuilder sb){
        return sb.toString().equals(sb.reverse().toString());
    }
    
    
    
}