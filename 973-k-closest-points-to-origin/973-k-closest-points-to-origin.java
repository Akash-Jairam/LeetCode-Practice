class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a function to find the distance from k to the origin
        // Priority queue take the distance as a lambda function and it will keep the closest at the top
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(findSquaredDistance(x[0], x[1]), findSquaredDistance(y[0],y[1])));
        for(int[] point : points){
            pq.offer(point);
        }
        
        for(int i = 0; i < k; ++i){
            result[i] = pq.remove();
        }
        
        return result;
    }
    
    protected int findSquaredDistance(int x, int y){
        return x * x + y *y;
    }
}