class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Create a stringbuilder that is of size s.length()
        // Iterate through the string from right to left and use a variable to keep track of k
        // If the character is a '-', we skip it
        // Else we append the character to our resultstring
        // We then decrement our variable and check to see if it is 0
        // If so, we reset it to k and append a dash to our resultstring
        // Return the string result
        String key = "";
        char[] sChars = s.toCharArray();
        int count = k;
        
        for(int i = sChars.length-1; i >=0; --i){
            if(sChars[i] != '-'){
                key = sChars[i] + "" + key;
                --count;
                if(count == 0){
                    count = k;
                    key =  '-' + key;
                }
            }
        }
        if(key.length() > 1 && key.charAt(0) == '-' )
            key = key.substring(1);
        
        return key.toUpperCase();
    }
}