class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 1)
            return intervals;
        
        // Create a list to hold our result
        // Sort intervals
        // Create a variable to point to the current interval
        // Iterate through the array and compare the current interval to the next interval
        // If they overlap, merge them else add the current interval to your list and set the pointer to the current next interval 
        // Finally, check to see if the final current interval is in our list. If it is not, add it
        // Conver the list to an array and return it
        Arrays.sort(intervals, ((arr1, arr2) -> arr1[0] - arr2[0]));
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        
        for(int i = 1; i < intervals.length; ++i){
            if(curr[1] >= intervals[i][0]){
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else{
                res.add(curr);
                curr = intervals[i];
            }
        }
        
        if(!res.contains(curr))
            res.add(curr);
        
        return res.toArray(new int[res.size()][2]);
    }
}