/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        List<String> currWords = new ArrayList<>();
        for(String word : words){
            currWords.add(word);
        }
        
        Random rand = new Random();
        int matches = 0;
        
        
        for(int i = 0; i < 10 && matches != 6; ++i){
            String currWord = currWords.get(rand.nextInt(currWords.size()));
            matches = master.guess(currWord);
            
            List<String> matchedWords = new ArrayList<>();
            for(String word : currWords){
                if(isMatch(word, currWord, matches)){
                    matchedWords.add(word);
                }
            }
            currWords = matchedWords;
        }
        
        System.out.println(matches == 6 ? "Either you took too many guesses, or you did not find the secret word." : "You guessed the secret word correctly.");
    }
    
    public boolean isMatch(String word, String currWord, int match){
        
        for(int i = 0; i < word.length(); ++i){
            if(word.charAt(i) == currWord.charAt(i))
                --match;
        }
        
        return match == 0;
    }
}