class Solution {
    public int coinChange(int[] coins, int amount) {
        // Use a bottom up dynamic programming approach
        // Create an array of size amount +1 to keep track of all the minimum coin counts until we reach our ammount
        // Set all values in the created array to amount +1
        // Iterate through our created array 
        // Iterate through our coins array and set the value at the current index of our created array to the minimum of the index itself and 1 + the value at the previous index
        int[] dynamicProgramming = new int[amount+1];
        Arrays.fill(dynamicProgramming, amount+1);
        dynamicProgramming[0] = 0;
        Arrays.sort(coins);
        
        for(int i = 1; i <= amount; ++i){
            for(int j = 0; j < coins.length; ++j){
                if(coins[j] <= i)
                    dynamicProgramming[i] = Math.min(dynamicProgramming[i], dynamicProgramming[i-coins[j]] + 1);
                else
                    break;
            }
        }
        
        return dynamicProgramming[amount] == amount+1 ? -1 : dynamicProgramming[amount];
    }
}