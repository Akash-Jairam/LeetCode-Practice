class Solution:
    def nextPermutation(self, nums):
        # Find the last peak by iterating from right to left through the array and returning the first number you find where the number to the left of it is lower than it
        # The point to the left of the last peak is the pivot
        # If the pivot is not equal to -1, we will iterate through the array once more from right to left and find the index of the first value that is greater than the pivot
        # Swap the values at the pivot and the index of the first value from the right that is greater than the pivot
        # Reverse all the values between the position after the pivot and the end of the array
        pivot = self.findLastPeak(nums) - 1
        if pivot != -1:
            swapPos = self.findFirstGreaterThanPivot(nums, pivot)
            self.swap(nums, pivot, swapPos)
        self.reverse(nums, pivot + 1)

    def findLastPeak(self, nums):
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                return i
        return 0

    def findFirstGreaterThanPivot(self, nums, pivot):
        for i in range(len(nums) - 1, pivot, -1):
            if nums[i] > nums[pivot]:
                return i
        return pivot + 1

    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]

    def reverse(self, nums, start):
        end = len(nums) - 1
        while start < end:
            self.swap(nums, start, end)
            start += 1
            end -= 1
