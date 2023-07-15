class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        1. Find the last peak which is index of the first number from the right which is greater than the number to the left of it
        2. pivot = lastPeak - 1
        3. If pivot is not -1, find the first number from the right which is greater than the pivot (the swapPoint). Then swap the number at the pivot with the number at the swapPoint
        4. Reverse all the numbers after the swap point
        """
        pivot = self.findLastPeak(nums) - 1
        if pivot != -1:
            swapPoint = self.findSwapPoint(nums, pivot)
            nums[pivot], nums[swapPoint] =  nums[swapPoint], nums[pivot]

        self.reverse(nums, pivot + 1)
    
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
    
    
    