class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] cArr = colors.toCharArray();
        int res = 0;
        for(int i = 1; i < cArr.length; ++i){
            if(cArr[i] == cArr[i-1]){
                res += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        
        return res;
    }
}