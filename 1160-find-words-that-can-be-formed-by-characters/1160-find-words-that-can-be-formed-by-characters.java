class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] charsMap = map(chars);
        
        for(String word : words){
            int[] wordMap = map(word);
            if(compare(charsMap, wordMap, word.length()))
                sum += word.length();
        }
        
        return sum;
    }
    
    public int[] map(String s){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        
        return arr;
    }
    
    public boolean compare(int[] charsMap, int[] wordMap, int wordLength){
        for(int i = 0; i < 26; ++i){
            if(wordMap[i] <= charsMap[i]){
                wordLength -= wordMap[i];
            }
        }
        
        return wordLength == 0;
    }
}