class Solution {
    private Integer[][][] memo = new Integer[101][21][101];
    private int max = (int)1e8, m, n;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        int res = dfs(houses, cost, 0, 0, target);
        return res >= max ? -1 : res;
    }
    
    public int dfs(int[] houses, int[][] cost, int houseIdx, int prevColor, int target){
        if(houseIdx == m || target < 0)
            return target == 0 ? 0 : max;
        
        if(memo[houseIdx][prevColor][target] != null)
            return memo[houseIdx][prevColor][target];
        
        if(houses[houseIdx] != 0){ // House is already painted. Check to see if it forms a new hood or not
            int currentColor = houses[houseIdx];
            return memo[houseIdx][prevColor][target] = dfs(houses, cost, houseIdx + 1, currentColor, target - (currentColor != prevColor ? 1 : 0));
        }
        
        int res = max;
        for(int currentColor = 1; currentColor <= n; ++currentColor){
            int val = dfs(houses, cost, houseIdx + 1, currentColor, target - (currentColor != prevColor ? 1: 0));
            res = Math.min(res, val + cost[houseIdx][currentColor - 1]);
        }
        
        memo[houseIdx][prevColor][target] = res;
        return res;
    }
}