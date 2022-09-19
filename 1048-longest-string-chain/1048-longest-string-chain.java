class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for(String word : words){
            int best = 0;
            for(int i = 0; i < word.length(); ++i){
                String toCheck = word.substring(0, i) + word.substring(i+1);
                best = Math.max(best, map.getOrDefault(toCheck, 0) + 1);
            }
            map.put(word, best);
            res = Math.max(res, best);
        }
        
        return res;
    }
}