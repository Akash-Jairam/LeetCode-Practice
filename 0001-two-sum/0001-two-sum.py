class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}
        
        for i in range(len(nums)):
            if target - nums[i] in num_map:
                return [num_map[target - nums[i]], i]
            
            num_map[nums[i]] = i
        
        
        return [-1, -1]
        
        