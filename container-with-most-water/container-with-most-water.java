class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = -1;
        while(i < j){
            int currentArea = Math.min(height[i], height[j]) * (j-i);
            if(currentArea > maxArea)
                maxArea = currentArea;
            
            if(i+1 < j && j-1 > i){
                if(height[i] < height[j]){
                    i++;
                }else
                    j--;
            } else{
                j--;
            }     
        }
        
        return maxArea;
    }
}