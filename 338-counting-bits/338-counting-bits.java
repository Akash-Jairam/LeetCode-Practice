class Solution {
    public int[] countBits(int n) {
        // Use a dynamic programming bottom up approach
        // We'll set 0 to 0
        // We will use a for loop that goes from 0 to n 
        // We will set the count at the index of 'i' to the count at the index of 'i/2'
        // If i is an odd number, we will increment the count stored at index 'i' by 1
        int[] count = new int[n+1];
        count[0] = 0;
        
        for(int i = 1; i <= n; ++i){
            count[i] = count[i/2];
            if(i % 2 == 1)
                count[i]++;
        }
        
        return count;
    }
}