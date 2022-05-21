class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return -1;
        
        if(word1 == null && word2 != null)
            return word2.length();
        
        if(word1 != null && word2 == null)
            return word1.length();
        
        int[][] dp = new int[word1.length()+1][word2.length() + 1];
        
        for(int i = 0; i < dp[0].length; ++i){
            dp[0][i] = i;
        }
        
        for(int i = 0; i < dp.length; ++i){
            dp[i][0] = i;
        }
        
        for(int i = 1; i < dp.length; ++i){
            char w1 = word1.charAt(i - 1);
            for(int j = 1; j < dp[0].length; ++j){
                char w2 = word2.charAt(j - 1);
                if(w1 != w2){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j-1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}