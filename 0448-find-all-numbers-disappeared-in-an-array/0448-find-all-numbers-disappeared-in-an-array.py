class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Swap items
        n, res = len(nums), []
        
        for i in range(n):
            while nums[nums[i] - 1] !=  nums[i]:
                nums[nums[i]-1], nums[i] = nums[i], nums[nums[i]-1]  # swap

        
        for i in range(n):
            if nums[i] != i + 1:
                res.append(i+1)
        
        return res
