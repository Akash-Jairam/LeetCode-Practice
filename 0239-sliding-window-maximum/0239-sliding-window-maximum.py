from collections import deque
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        l = 0
        q = deque()
        for r in range(len(nums)):
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            
            q.append(r)
            # Remove left value from deque if it is out of the window
            if l > q[0]:
                q.popleft()
                
            if r + 1 >= k:
                res.append(nums[q[0]])
                l += 1
        
        return res
        