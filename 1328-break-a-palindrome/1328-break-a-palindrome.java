class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] arr = palindrome.toCharArray();
        int i = 0;
        while(i < arr.length/2 && arr[i] == 'a') ++i;
        if(i == arr.length/2){
            arr[arr.length-1] = 'b';
        } else
            arr[i] = 'a';
        return new String(arr);
    }
}