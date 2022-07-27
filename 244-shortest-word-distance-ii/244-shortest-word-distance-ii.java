class WordDistance {
    
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; ++i){
           map.putIfAbsent(wordsDict[i], new ArrayList<>());
           map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
       int min = Integer.MAX_VALUE;
       for(int i : map.get(word1)){
           for(int j : map.get(word2)){
               min = Math.min(min, Math.abs(i-j));
           }
       }
        
       return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */