class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Create a priority queue to hold which of our meeting rooms are booked with the one with the earliest ending at the front 
        // Iterate through our intervals array
        // If our queue is not empty and there is an element in our priority queue that ends before the start of our interval, we "use that meeting room" for our current meeting by kicking out the people who are in that room lol
        // We will add the current interval into our queue
        
        // Finally, we return the size of the priorityqueue as our result
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> (arr1[1] - arr2[1]));
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        for(int[] interval : intervals){
            if(!pq.isEmpty() && pq.peek()[1] <= interval[0])
                pq.poll();
            
            pq.offer(interval);
        }
        
        return pq.size();
    }
}