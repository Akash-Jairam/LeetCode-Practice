class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return -1;
        
        if(word1.length() == 0)
            return word2.length();
        
        if(word2.length() == 0)
            return word1.length();
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int[][] matched = new int[c1.length+1][c2.length+1];
        
        for(int i = 0; i <= c1.length; ++i){
            matched[i][0] =i;
        }
        
        for(int i = 0; i <= c2.length; ++i){
            matched[0][i] = i;
        }
        
        
        for(int i = 0; i < c1.length; ++i){
            for(int j = 0; j < c2.length; ++j){
                if(c1[i] == c2[j])
                    matched[i+1][j+1] = matched[i][j];
                else{
                    matched[i+1][j+1] = Math.min(Math.min(matched[i][j + 1], matched[i + 1][j]), matched[i][j]) + 1;
                }
            }
        }
        
        return matched[c1.length][c2.length];
    }
    
    
}