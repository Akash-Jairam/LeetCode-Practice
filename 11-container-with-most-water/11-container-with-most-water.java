class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height == null || height.length < 2)
            return maxArea;
        
        int start = 0, end = height.length -1;
        while(start < end){
            int currArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, currArea);
            
            if(height[start] < height[end])
                ++start;
            else
                --end;
        }
        
        return maxArea;
    }
}