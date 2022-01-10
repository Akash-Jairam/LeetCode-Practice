class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] secondArray = new int[k];
        int secondArrayCount = 0;
        int start = nums.length-1-k;
        
        for(int i = k-1; i >= 0; i--){
            secondArray[i] = nums[nums.length-1-secondArrayCount];
            secondArrayCount++;
        }
        
        for(int i = nums.length-1; i >= k; i--){
            nums[i] = nums[start];
            start--;
        }
        
        for(int i = 0; i < k; i++){
            nums[i] = secondArray[i];
        }
    }
}