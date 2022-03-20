public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1;
        int res = 0;
        for(int i = 0; i < 32; ++i){
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;

        }
        
        return res;
    }
}