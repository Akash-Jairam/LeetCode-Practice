class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotatedArray = new int[nums.length];
        if(k > nums.length){
            k = k - nums.length;
        }
        int pos = nums.length-1;
        
        if(nums.length == 1 || k == 0 || k == nums.length)
            return;
        else if(nums.length ==2){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        } 
        
        
        
        for(int i = k -1; i >= 0 && i <= nums.length-1; i--){
            rotatedArray[i] = nums[pos];
            pos--;
        }
        pos = 0;
        for(int j = k; j < nums.length; j++){
            rotatedArray[j] = nums[pos];
            pos++;
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = rotatedArray[i];
        }
    }
}