class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cMap = map(chars);
        int count = 0;
        for(String word : words){
            int[] curr = map(word);
            boolean canBeFormed = true;
            for(int i = 0; i < 26; ++i){
                if(curr[i] > cMap[i]){
                    canBeFormed = false;
                    break;
                }
            }
            
            if(canBeFormed){
                count += word.length();
            }
        }
        
        return count;
    }
    
    public int[] map(String s){
        int[] map = new int[26];
        for(int i = 0; i < s.length(); ++i){
            map[s.charAt(i) - 'a']++;
        }
        
        return map;
    }
}