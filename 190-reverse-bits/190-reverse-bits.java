public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // Create a variable to hold our result
        // Iterate through n until it is equal to 0
        // Shift our variable to the left by 1
        // Add (n & 1) to our variable using |
        // Shift n to the right by 1
        int reversed = 0;
        for(int i = 0; i < 32; ++i){
            reversed = reversed << 1;
            reversed =  reversed | (n & 1);
            n = n >> 1;
        }
        
        return reversed;
    }
}