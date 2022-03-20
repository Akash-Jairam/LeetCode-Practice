class Solution {
    public int getSum(int a, int b) {
        // Generally to add two numbers using bit manipulation, we use XOR to do the basic addition
        // We also need to use AND to find which places have carries
        // We need to do a left shift of that AND to place the carries at the correct place
        // We will use b to hold our carries and a to hold the sum
        // Our loop will keep going until we have nothing left to carry
        while(b != 0){
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        
        return a;
    }
}