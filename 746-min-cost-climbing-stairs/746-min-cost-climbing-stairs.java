class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int secondToCurr = cost[0];
        int prev = cost[1];
        
        for(int i = 2; i < cost.length; ++i){
            int temp = prev;
            prev = cost[i] + Math.min(prev, secondToCurr);
            secondToCurr = temp;
        }
        
        return Math.min(prev, secondToCurr);
    }
}