class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = -1;
        int bestRightSpotScore = values[values.length-1] - (values.length-1);
        
        for(int i = values.length-2; i >= 0; --i){
            max = Math.max(max, values[i] + i + bestRightSpotScore);
            bestRightSpotScore = Math.max(bestRightSpotScore, values[i] - i);
        }
        
        return max;
    }
}