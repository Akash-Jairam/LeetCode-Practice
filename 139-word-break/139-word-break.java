class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int len = 1; len <= s.length(); ++len){
            for(int j = len -1; j >= 0; --j){
                if(dp[j] && wordDict.contains(s.substring(j, len))){
                    dp[len] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
}