class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n, lastPos = len(nums) - 1, len(nums) -1
        
        
        for i in range(n - 1, -1, -1):
            if(i + nums[i] >= lastPos):
                lastPos = i
        
        return lastPos == 0
        