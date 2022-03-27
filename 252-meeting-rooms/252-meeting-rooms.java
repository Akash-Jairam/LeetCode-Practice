class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return true;
        
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        int[] prev = intervals[0];
        
        for(int i = 1; i < intervals.length; ++i){
            if(prev[1] > intervals[i][0])
                return false;
            else{
                prev = intervals[i];
            }
        }
        return true;
    }
}