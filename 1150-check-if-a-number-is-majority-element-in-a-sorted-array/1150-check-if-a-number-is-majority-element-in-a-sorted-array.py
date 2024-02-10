class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        count = 0
        
        for num in nums:
            if target == num:
                count += 1
        
        return count > len(nums) // 2