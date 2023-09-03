class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        lastPeak = self.findLastPeak(nums)
        pivot = lastPeak - 1
        if pivot != -1:
            swapPoint = self.findSwapPoint(nums, pivot)
            nums[pivot], nums[swapPoint] = nums[swapPoint], nums[pivot]
        self.reverse(nums, pivot + 1)
        return nums
    
    def findLastPeak(self, nums):
        i = len(nums) - 1
        
        while i > 0:
            if nums[i] > nums[i-1]:
                return i
            i -= 1
        return 0
    
    def findSwapPoint(self, nums, pivot):
        i = len(nums) - 1
        while i >= 0:
            if nums[i] > nums[pivot]:
                return i
            i -= 1
        
        return pivot + 1
    
    def reverse(self, nums, i):
        j = len(nums) - 1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        
        