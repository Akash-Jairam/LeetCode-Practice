class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return intervals;
        
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        int[] interval = intervals[0];
        List<int[]> list = new LinkedList<>();
        for(int i = 1; i < intervals.length; ++i){
            if(interval[1] >= intervals[i][0]){
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else{
                list.add(interval);
                interval = intervals[i];
            }
        }
    
        if(!list.contains(interval)) list.add(interval);
        
        return list.toArray(new int[list.size()][]);
    }
}