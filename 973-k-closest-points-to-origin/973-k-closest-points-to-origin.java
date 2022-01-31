class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (x,y) -> squaredDistance(x) - squaredDistance(y));
        return Arrays.copyOf(points, k);
    }
    
    private int squaredDistance(int[] array){
        return array[0] * array[0] + array[1] * array[1];
    }
}