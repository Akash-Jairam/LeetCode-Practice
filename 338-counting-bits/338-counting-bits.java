class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1; i <= n; ++i){
            int index = i >> 1;
            res[i] = res[index];
            if(i % 2 == 1)
                res[i] += 1;
        }
        
        return res;
    }
    
   
}