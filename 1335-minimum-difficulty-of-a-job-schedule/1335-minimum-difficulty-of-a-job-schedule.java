class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final int N = jobDifficulty.length;
        if(N < d) return -1;
        
        int[][] memo = new int[N][d+1];
        for(int[] row : memo) Arrays.fill(row, -1);
        
        return dfs(d, 0, jobDifficulty, memo);
    }
    
    public int dfs(int d, int len, int[] jobDifficulty, int[][] memo){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) return 0;
        if(d == 0 || len == N) return Integer.MAX_VALUE;
        if(memo[len][d] != -1) return memo[len][d];
        
        int currMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        
        for(int schedule = len; schedule < N; ++schedule){
            currMax = Math.max(currMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, memo);
            if(temp != Integer.MAX_VALUE) min = Math.min(min, temp + currMax);
        }
        
        memo[len][d] = min;
        return min;
    }
}