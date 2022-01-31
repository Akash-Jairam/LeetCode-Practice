class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y) ->
       (y[0] * y[0] + y[1] * y[1]) - (x[0] * x[0] + x[1] * x[1]) );
        
        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
    
}