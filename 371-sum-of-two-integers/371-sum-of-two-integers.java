class Solution {
    public int getSum(int a, int b) {
        // a will be used to hold our result
        // b will be used to hold our carry
        // Use a while loop which will end when b is 0 (there are no more carries)
        // In the loop:
        // We will XOR a and b to perform the addition at the current stage
        // To determine the carry, we will '&' a and b before left shifting the result
        while( b != 0){
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        
        return a;
    }
}