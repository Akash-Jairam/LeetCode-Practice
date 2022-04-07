class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 1)
            return 0;
        
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[1] - arr2[1]));
        
        int[] curr = intervals[0];
        int res = 0;
        for(int i = 1; i < intervals.length; ++i){
            if(curr[1] > intervals[i][0]){
                ++res;
            } else{
                curr = intervals[i];
            }
        }
        return res;
    }
}