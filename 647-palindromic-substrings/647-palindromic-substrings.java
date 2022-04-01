class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        if(s.isBlank() || s.isEmpty())
            return count;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < s.length(); ++i){
            count += isPalindrome(i, i, arr);
            count += isPalindrome(i, i+1, arr);
        }
        
        return count;
    }
    
    public int isPalindrome(int start, int end, char[] arr){
        int count = 0;
        
        while(start >= 0 && end < arr.length && arr[start] == arr[end]){
            ++count;
            --start;
            ++end;
        }
        
        return count;
    }
}