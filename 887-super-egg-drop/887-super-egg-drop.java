class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k+1];
        int numSteps = 0;
        
        while(dp[k] < n){
            ++numSteps;
            
            for(int i = k; i > 0; --i){
                dp[i] += dp[i-1] + 1;
            }
        }
        
        return numSteps;
    }
}