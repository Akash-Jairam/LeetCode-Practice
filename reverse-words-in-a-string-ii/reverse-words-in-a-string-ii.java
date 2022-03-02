class Solution {
    public void reverseWords(char[] s) {
        swapChars(s, 0, s.length-1);
        int begin = 0;
        for(int i = 0; i < s.length; ++i){
            if(s[i] == ' '){
                swapChars(s, begin, i-1);
                begin = i+1;
            }
        }
        
        swapChars(s, begin, s.length-1);
        
        return;
        
    }
    
    public void swapChars(char[] s, int begin, int end){
        while(begin < end){
            char temp = s[end];
            s[end] = s[begin];
            s[begin] = temp;
            ++begin;
            --end;
        }
    }
}