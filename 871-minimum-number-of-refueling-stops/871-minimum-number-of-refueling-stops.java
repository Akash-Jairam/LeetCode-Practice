class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel)
            return 0;
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x, y) -> (y - x));
        maxQueue.offer(startFuel);
        int stops = -1, currPos = 0, currStation = 0;
        while(currPos < target && !maxQueue.isEmpty()){
            currPos += maxQueue.poll();
            ++stops;
            while(currStation < stations.length && stations[currStation][0] <= currPos){
                maxQueue.offer(stations[currStation][1]);
                ++currStation;
            }
        }
        
        return target <= currPos ? stops : -1;
    }
}