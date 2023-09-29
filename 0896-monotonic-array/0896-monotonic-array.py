class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        inc, dec = True, True
        
        for i in range(0, len(nums)-1):
            inc = inc and nums[i] >= nums[i+1]
            dec = dec and nums[i] <= nums[i+1]
        
        return inc or dec