class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        int last = rectangles.length-1;
        HashMap<Double, Integer> map = new HashMap<>();
        map.put(Double.valueOf(rectangles[last][0]) / Double.valueOf(rectangles[last][1]),1);
        
        for(int i = last-1; i >=0; --i){
            Double current = Double.valueOf(rectangles[i][0]) / Double.valueOf(rectangles[i][1]);
            count += map.getOrDefault(current, 0);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        
        return count;
    }
}