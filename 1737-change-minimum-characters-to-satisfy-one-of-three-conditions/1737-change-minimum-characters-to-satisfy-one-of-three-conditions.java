class Solution {
    public int minCharacters(String a, String b) {
        // Create 2 arrays to track the character count in both strings
        int[] aMap = new int[26];
        int[] bMap = new int[26];
        
        for(char c : a.toCharArray()){
            aMap[c - 'a']++;
        }
        
        for(char c : b.toCharArray()){
            bMap[c - 'a']++;
        }
        
        int min = Integer.MAX_VALUE;
        // Iterate through each character in the alphabet
        // Check to see how much characters in a and b are different from the current character;
        // if the current index is greater than 0, add the previous count to the current index in our array map
        // this is to create a running total of all the lesser characters
        // See how much characters in a and b are greater than the current character
        for(int i = 0; i < 26; ++i){
            min = Math.min(min, a.length() - aMap[i] + b.length() - bMap[i]);
            
            if(i > 0){
                aMap[i] += aMap[i-1];
                bMap[i] += bMap[i-1];
            }
            
            
            if(i < 25){
                min = Math.min(min, a.length() - aMap[i] + bMap[i]);
                min = Math.min(min, b.length() - bMap[i] + aMap[i]);
            }
        }
        
        return min;
    }
}