class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] dp = new Integer[s.length()];
        return n == 0 ? 0 : findDecodings(0, dp, s);
    }
    
    public int findDecodings(int i, Integer[] dp, String s){
        int n = s.length();
        
        if(i == n) return 1;
        
        if(s.charAt(i) == '0') return 0;
        
        if(dp[i] != null) return dp[i];
        
        int res = findDecodings(i+1, dp, s);
        
        if(i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' &&  s.charAt(i+1) < '7')))
            res += findDecodings(i+2, dp, s);
        
        dp[i] = res;
        return res;
        
    }
}