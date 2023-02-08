class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        i, maxReachable, lastJumpedPos, jumps = 0,0,0,0
        
        while lastJumpedPos < n - 1:
            maxReachable = max(maxReachable, i + nums[i])
            
            if i == lastJumpedPos:
                lastJumpedPos = maxReachable
                jumps += 1
            
            i += 1
        
        return jumps