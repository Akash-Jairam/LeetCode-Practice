class Solution {
    public int trap(int[] height) {
        int totalWater = 0, left = 0, right = height.length-1, leftMax = height[0], rightMax = height[height.length-1];
        
        while(left < right){
            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        
        return totalWater;
    }
}