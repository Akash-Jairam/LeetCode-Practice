class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magMap = new int[26];
        
        for(int i = 0; i < magazine.length(); ++i){
            magMap[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < ransomNote.length(); ++i){
            char c = ransomNote.charAt(i);
            if(magMap[c - 'a'] == 0)
                return false;
            magMap[c - 'a']--;
        }
        
        return true;
    }
}