class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (x,y) -> findLength(x) - findLength(y));
        return Arrays.copyOf(points, k);
    }
    
    public int findLength(int[] array){
        return array[0] * array[0] + array[1] * array[1];
    }
}