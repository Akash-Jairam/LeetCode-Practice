class Solution {
    public int coinChange(int[] coins, int amount) {
        // Bottom up approach
        // Find the min # of coins from 0 to amount and store in in a dp array of amount + 1 size
        // Set all the values in the array to amount + 1 size (this will be the flag to tell us whether the number of coins is vlaid)
        // Set dp[0] to 0 since the minimum number of coins for 0 is 0
        // Create a for loop from 1 to amount (inclusive)
        // Iterate through our array of coins
        // If the coin is less than the amount (current index)
        // Update dp of that index to the minimum of the existing value and 1 + dp[current index - coin value]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; ++i){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}