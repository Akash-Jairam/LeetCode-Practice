class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array to store our optimal number of coins from 0 to amount+1
        // Fill our array with values of amount plus 1
        // Assign 0 to the first index of our array since the optimal solution is 0
        // Create a for loop that goes from 1 to amount 
        // Create an inner loop that loops through the coins in the array
        // If the coin is <= to the ammount, choose the lesser of array[amount - coin] + 1 and amount
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; ++i){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}