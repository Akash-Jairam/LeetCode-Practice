class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int steps = 0;
        
        while(dp[k] < n){
            ++steps;
            
            for(int i = k; i > 0; --i){
                dp[i] += dp[i-1] + 1;
            }
        }
        
        return steps;
    }
}