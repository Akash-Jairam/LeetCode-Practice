class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero_idx, two_idx = 0, len(nums) - 1
        start = 0
        
        while start <= two_idx:
            num = nums[start]
            if num == 0:
                nums[zero_idx], nums[start] = nums[start], nums[zero_idx]
                zero_idx += 1
                start += 1
            elif num == 2:
                nums[two_idx], nums[start] = nums[start], nums[two_idx]
                two_idx -= 1
            else:
                start += 1