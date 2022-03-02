class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array that will track the lowest number of coins from 0 to amount
        // Intialize it to an invalid value like amount + 1
        // Set the value at index 0 to zero
        // Iterate through the array, starting from index 1 and going to amount
        // In a subloop, iterate through each coin
        // If the coin is less than or equal to the current index
        // Assign the value at the index to the lesser of the value at the position of (index - coin) + 1 (plus one for the current coin) or the current value at the index
        
        // Return value at index[amount]
        
        int[] change = new int [amount+1];
        Arrays.fill(change, amount+1);
        change[0] = 0;
        
        for(int i = 0; i < amount+1; ++i){
            for(int coin : coins){
                if(coin <= i){
                    change[i] = Math.min(change[i-coin] + 1, change[i]);
                }
            }
        }
        
        return change[amount] != amount+1 ? change[amount] : -1;
    }
}