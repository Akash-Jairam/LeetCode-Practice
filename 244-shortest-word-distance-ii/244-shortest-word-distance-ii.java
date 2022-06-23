class WordDistance {
    HashMap<String, List<Integer>> map;
    HashMap<String, Integer> cache;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        cache = new HashMap<>();
        
        for(int i = 0; i < wordsDict.length; ++i){
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        String cacheKey = word1 + "::" + word2;
        if(cache.containsKey(cacheKey))
            return cache.get(cacheKey);
        
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        
        while(i < w1.size() && j < w2.size()){
            int w1Idx = w1.get(i);
            int w2Idx = w2.get(j);
            if(w1Idx > w2Idx){
                min = Math.min(min, w1Idx - w2Idx);
                ++j;
            } else{
                min = Math.min(min, w2Idx - w1Idx);
                ++i;
            }
            
            if(min == 1){
                cache.put(cacheKey, min);
                return min;
            }
        }
        
        cache.put(cacheKey, min);
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */