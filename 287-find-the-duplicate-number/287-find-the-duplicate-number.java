class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        // Let tortoise meet hare
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        // Hare wins. Give tortoise a second chance from the start to catch hare
        slow = 0;
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}