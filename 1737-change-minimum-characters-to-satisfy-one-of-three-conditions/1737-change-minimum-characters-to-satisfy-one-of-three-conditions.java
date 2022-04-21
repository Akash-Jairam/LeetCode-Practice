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
            res = Math.min(res, aLength - aCharCount[i] + bLength - bCharCount[i]);
            
            if(i > 0){
                aCharCount[i] += aCharCount[i-1];
                bCharCount[i] += bCharCount[i-1];
            }
            
            if(i < 25){
                res = Math.min(res, aLength - aCharCount[i] + bCharCount[i]);
                res = Math.min(res, bLength - bCharCount[i] + aCharCount[i]);
            }
        }
        
        return res;
    }
}