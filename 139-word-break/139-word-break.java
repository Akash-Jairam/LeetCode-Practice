class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int len = 1; len <= s.length(); ++len){
            for(int j = 0; j < len; ++j){
                if(dp[j] && wordDict.contains(s.substring(j, len))){
                    dp[len] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
}