class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        swapIdx = 1
        
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                nums[swapIdx] = nums[i]
                swapIdx += 1
        
        return swapIdx
        