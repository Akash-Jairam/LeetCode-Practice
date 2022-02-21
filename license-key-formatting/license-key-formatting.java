class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Create a stringbuilder with s.length size to save space
        // Starting from the right,iterate through each character in our string
        // If it's not a '-' we append it
        // If the stringbuilder length is divisible by k, we add a -
        // Check to see if the first character in the sb is a dash, if so remove
        // Return the sb converted to a string
        char[] chars = s.toCharArray();
        int numChars = 0;
        StringBuilder sb = new StringBuilder(s.length());
        
        for(int i = chars.length-1; i >= 0; --i){
            if(chars[i] != '-'){
                sb.append(chars[i]);
                ++numChars;
                if(numChars % k == 0)
                    sb.append('-');
            }
        }
        
        if(!sb.isEmpty() && sb.charAt(sb.length()-1) == '-')
            sb.deleteCharAt(sb.length()-1);
        

        
        return sb.reverse().toString().toUpperCase();
    }
}