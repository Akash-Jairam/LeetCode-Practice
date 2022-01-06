class Solution {
    public void moveZeroes(int[] nums) {
        int numberOfZeros = 0;
        int j = 1;
        if(nums.length == 1)
            return;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                while(j < nums.length-1 && nums[j] == 0){
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            } else{
                j = i+1;
            }
        }
    }
}