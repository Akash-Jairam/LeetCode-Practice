class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> (arr1[1] - arr2[1]));
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek()[1] <= interval[0]){
                pq.poll();
            }
            pq.offer(interval);
        }
        
        return pq.size();
    }
}