class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // Divide string length by k to see if the size of the parts are uneven
        // Iterate through the string from right to left. If the char at the current position 
        String key = "";
        int count = k;
        
        for(int i = s.length()-1; i >=0; --i){
            if(s.charAt(i) != '-'){
                if(count > 0)
                    key = s.charAt(i) + "" + key;
                else{
                    count = k;
                    key = s.charAt(i) + "-" + key;
                }
                --count;
            }
        }
        
        return key.toUpperCase();
    }
}