class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return 0;
        
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> (arr1[1] - arr2[1]));
        pq.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; ++i){
            int[] curr = intervals[i];
            int[] prev = pq.remove();
            
            if(prev[1] > curr[0]){
                pq.offer(prev);
            }
                
            pq.offer(curr);
        }
        
        return pq.size();
    }
}