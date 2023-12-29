class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        swapPt = 1
        
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                nums[swapPt] = nums[i]
                swapPt += 1
        
        return swapPt 