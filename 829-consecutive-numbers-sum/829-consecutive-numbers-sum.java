class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        
        int pos = 1;
        
        while(pos <= n){
            if(n % pos == 0)
                ++count;
            
            n -= pos;
            ++pos;
        }
        
        return count;
    }
}