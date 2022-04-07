class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Do obligatory edge case checks
        // Sort the intervals array
        // Create a list to hold our intervals
        // Iterate through the intervals array and add all the intervals that occur before our new interval into the list
        // Iterate through the intervals array while the current interval starts before the end of our "newInterval", making sure to merge the current interval into the new interval as needed
        // Add the remainind intervals to our list
        // Convert our list to an array and return it
        if(intervals == null || intervals.length == 0)
            return new int[][]{newInterval};
        
        if(newInterval == null || newInterval.length == 0)
            return intervals;
        
        int index = 0;
        List<int[]> res = new ArrayList<>();
        while(index < intervals.length && intervals[index][1] < newInterval[0]){
            res.add(intervals[index]);
            ++index;
        }
        
        while(index < intervals.length && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            ++index;
        }
        res.add(newInterval);
        
        while(index < intervals.length){
            res.add(intervals[index]);
            ++index;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}