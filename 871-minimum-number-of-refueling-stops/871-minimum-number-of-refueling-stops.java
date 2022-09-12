class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(startFuel);
        int numStops = -1, idx = 0;
        int currPos = 0;
        while(currPos < target && !pq.isEmpty()){
            currPos += pq.poll();
            ++numStops;
            while(idx < stations.length && stations[idx][0] <= currPos){
                pq.offer(stations[idx][1]);
                ++idx;
            }
        }
        
        return currPos >= target ? numStops : -1;
    }
}