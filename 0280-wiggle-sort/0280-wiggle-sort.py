class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        for i in range(n):
            if i % 2 == 0 and i < n -1 and nums[i] > nums[i+1]:
                idx = i
                while idx < n - 1 and nums[idx] > nums[idx + 1]:
                    idx += 1
                if idx < n:
                    nums[i], nums[idx] = nums[idx], nums[i]
            elif i % 2 == 1 and  i < n - 1 and nums[i] < nums[i+1]:
                idx = i
                while idx < n -1 and nums[idx] < nums[idx + 1]:
                    idx += 1
                if idx < n:
                    nums[i], nums[idx] = nums[idx], nums[i]
        
        