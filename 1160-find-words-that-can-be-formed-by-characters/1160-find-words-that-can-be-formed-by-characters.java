class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsMap = new int[26];
        mapWord(charsMap, chars);
        int res = 0;
        for(String word : words){
            int[] wordMap = new int[26];
            mapWord(wordMap, word);
            int count = 0;
            for(int i = 0; i < 26; ++i){
                if(wordMap[i] <= charsMap[i])
                    count += wordMap[i];
            }
            if(count == word.length())
                res += count;
        }
        
        return res;
    }
    
    public void mapWord(int[] map, String word){
        for(int i = 0; i < word.length(); ++i){
            map[word.charAt(i) - 'a']++;
        }
    }
}