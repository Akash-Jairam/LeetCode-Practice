class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        Find the last peak where the number is greater than the number before it
        The pivot = last peak - 1
        Find swap point which is index of the last number that is greater than the pivot
        swap everything between pivot and swap point
        """
        lastPeak = self.findLastPeak(nums)
        pivot = lastPeak - 1
        swapPt = len(nums) - 1
        if pivot > -1:
            swapPt = self.findSwapPt(nums, pivot)
            nums[pivot], nums[swapPt] = nums[swapPt], nums[pivot]
        self.reverse(pivot + 1, nums)
    
    
    def findLastPeak(self, nums):
        i = len(nums) - 1
        while i > 0:
            if nums[i] > nums[i - 1]:
                return i
            
            i -= 1
            
        return 0
    
    def findSwapPt(self, nums, pivot):
        i = len(nums) - 1
        
        while i >= 0:
            if nums[i] > nums[pivot]:
                return i
            
            i -= 1
        
        return i
    
    def reverse(self, l,  nums):
        r = len(nums) - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
    
    
    