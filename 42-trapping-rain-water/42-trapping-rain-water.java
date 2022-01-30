class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int leftMax = height[0], rightMax = height[height.length-1];
        int left = 0, right = height.length-1;
        int result = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
            } else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
            }
        }
        return result;
    }
}