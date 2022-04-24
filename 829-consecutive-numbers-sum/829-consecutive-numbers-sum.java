class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        
        for(int n = 2; n*(n+1)/2 <= N; ++n){
            int val = (N - n * (n+1)/2);
            if( val % n == 0)
                ++count;
        }
        
        return count+1;
    }
    
    // https://www.youtube.com/watch?v=oKOCYZd4m7E
}
