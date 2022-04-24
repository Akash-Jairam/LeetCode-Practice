class Solution {
    public int minCharacters(String a, String b) {
        // Use two arrays to map the letter count of the characters in a and b respectively
        // Create our minCharacters variable
        // Iterate through each letter in the alphabet
        // Calculate how many changes it would take to turn all the characters in both strings to the current character. This is done by subtracting the combined count of the current character from combined length of both strings 
        
        // Update the value at the current index for both maps to the sum of all characters before it
        // Calculate how much changes it would take to make every character in string a be less than or equal to the current letter and how many changes it would take to make every character in b greater than the current letter
        // Do the same for b 
        // Update the minimum if necessary
        // Return minimum
        int[] aMap = new int[26];
        int[] bMap = new int[26];
        int aLength = a.length();
        int bLength = b.length();
        for(int i = 0; i < aLength; ++i){
            aMap[a.charAt(i) - 'a']++; 
        }
        
        for(int i = 0; i < bLength; ++i){
            bMap[b.charAt(i) - 'a']++;
        }
        int min = Math.max(aLength, bLength);
        
        for(int i = 0; i < 26; ++i){
            min = Math.min(min, aLength - aMap[i] + bLength - bMap[i]);
            
            if(i > 0){
                aMap[i] += aMap[i-1];
                bMap[i] += bMap[i-1];
                
            }
            
            if(i < 25){
                min = Math.min(min, aLength - aMap[i] + bMap[i]);
                min = Math.min(min, bLength - bMap[i] + aMap[i]);
            }
        }
        
        return min;
    }
}