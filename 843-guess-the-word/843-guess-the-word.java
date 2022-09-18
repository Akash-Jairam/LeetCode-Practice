/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> cands = new ArrayList<>();
        for(String w : words)
            cands.add(w);
        Random rand = new Random();
        int matches = 0;
        for(int i = 0; i < 10 && matches != 6; ++i){
            String curr = cands.get(rand.nextInt(cands.size()));
            matches = master.guess(curr);
            List<String> nextCands = new ArrayList<>();
            
            for(String s : cands){
                if(getMatches(s, curr, matches)){
                    nextCands.add(s);
                }
            }
            
            cands = nextCands;
        }
        
        System.out.println(matches == 6 ? "Either you took too many guesses, or you did not find the secret word." : "You guessed the secret word correctly.");
    }
    
    public boolean getMatches(String s1, String s2, int matches){
        for(int i = 0; i < s1.length(); ++i){
            if(s1.charAt(i) == s2.charAt(i)) --matches;
        }
        
        return matches == 0;
    }
}