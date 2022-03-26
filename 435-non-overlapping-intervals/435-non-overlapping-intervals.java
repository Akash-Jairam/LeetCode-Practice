class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0 || intervals.length == 1)
            return 0;
        
        // Sort the intervals
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        // Create a variable to track our count
        int count = 0;
        // Create an array that will track the previous interval and initialize it ot the first arrayin interval
        int[] previous = intervals[0];
        
        // Iterate through the other elements in interval
        for(int i = 1; i < intervals.length; ++i){
        // If the last element in previous is greater than the first element in interval, check to see if the last element in previous is greater than the last element in interval, if that's the case, we increment our count and set previous to the current interval
            if(previous[1] > intervals[i][0]){
                ++count;
                if(previous[1] > intervals[i][1]){
                    
                    previous = intervals[i];
                }
            } else{
                previous = intervals[i];
            }
        // Else we just set previous to the current interval
        }
        
        return count;
    }
}