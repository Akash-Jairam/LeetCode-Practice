class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int)(1e9 + 7);
        int length = 0;
        long result = 0;
        for(int i = 1; i <= n; ++i){
            if((i & i - 1) == 0){
                ++length;
            }
            
            result = ((result << length) | i) % mod;
        }
        
        return (int) result;
    }
}