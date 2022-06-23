class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int w1 = -1, w2 = -1;
        int res = wordsDict.length+1;
        for(int i = 0; i < wordsDict.length; ++i){
            if(wordsDict[i].equals(word1))
                w1 = i;
            
            if(wordsDict[i].equals(word2))
                w2 = i;
            
            if(w2 != -1 && w1 != -1){
                res = Math.min(res, Math.abs(w2 - w1));
            }
        }
        
        return res;
    }
}