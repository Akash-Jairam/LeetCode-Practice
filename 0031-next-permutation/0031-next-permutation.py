class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        1. Find last peak
        2. Pivot = last peak - 1
        3. Find swap point aka index of the last number that is greater than the number at the pivot
        4. Swap the numbers at the pivot and the swap point
        5. Reverse all the numbers after the pivot
        """
        lastPeak = self.findLastPeak(nums)
        pivot = lastPeak - 1
        if pivot != -1:
            swapPt = self.findSwapPt(nums, pivot)
            nums[swapPt], nums[pivot] = nums[pivot], nums[swapPt]
        self.reverse(nums, pivot + 1)
        return nums
    
    def findLastPeak(self, nums):
        i = len(nums) - 1
        while i > 0:
            if nums[i] > nums[i-1]:
                return i
            i -= 1
        return 0
    
    
    def findSwapPt(self, nums, pivot):
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