class Solution {
    public int minCharacters(String a, String b) {
        int[] aCharCount = new int[26];
        int[] bCharCount = new int[26];
        int aLength = a.length();
        int bLength = b.length();
        int res = Math.max(aLength, bLength) -1;
        
        for(int i = 0; i < aLength; ++i){
            aCharCount[a.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < bLength; ++i){
            bCharCount[b.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; ++i){
            // Find how many changes it would take to make both a and b consist of only the current character
            // This would mean finding the total character count and subtracting it from the current character count
            res = Math.min(res, aLength - aCharCount[i] + bLength - bCharCount[i]);
            
            if(i > 0){
                // Get the current count of the number of characters that are i or less in a and b respectively
                aCharCount[i] += aCharCount[i-1];
                bCharCount[i] += bCharCount[i-1];
            }
            
            if(i < 25){
                // We find the amount of changes needed to convert the remaining characters in a that are not less than the current letter and we need to add the amount of characters in b that are less than the current letter (since no character in b can be less than the current character )
                // Do this again but swap a and b
                // Find the min of res and these
                res = Math.min(res, aLength - aCharCount[i] + bCharCount[i]);
                res = Math.min(res, bLength - bCharCount[i] + aCharCount[i]);
            }
        }
        
        return res;
    }
}