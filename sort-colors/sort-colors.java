class Solution {
    public void sortColors(int[] nums) {
        int num0s = 0;
        int num1s = 0;
        int num2s = 0;
        
        for(int num : nums){
            if(num == 0)
                ++num0s;
            else if(num == 1)
                ++num1s;
            else if(num == 2)
                ++num2s;
        }
        
        int index = 0;
        index = fill(nums, index,  num0s, 0);
        index = fill(nums, index, num1s, 1);
        fill(nums, index, num2s, 2);
    }
    
    public int fill(int[] nums, int index, int count, int num){
        
        for(int i = 0; i < count; ++i){
            nums[index] = num;
            ++index;
        }
        
        return index;
    }
    
    
}