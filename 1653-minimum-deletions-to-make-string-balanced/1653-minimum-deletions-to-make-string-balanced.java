class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int res = 0;
        
        for(int i = 0; i < s.length(); ++i){
            int l = s.charAt(i);
            if(l == 'a')
                res = Math.min(res + 1, bCount);
            else if(l == 'b')
                ++bCount;
        }
        
        return res;
    }
}