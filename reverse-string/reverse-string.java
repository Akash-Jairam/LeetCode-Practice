class Solution {
    public void reverseString(char[] s) {
        if(s.length == 1)
            return;
        
        int i = 0;
        int j= s.length -1;
        
        while(i < j){
            char toSwap = s[i];
            s[i] = s[j];
            s[j] = toSwap;
            i++;
            j--;
        }
    }
}