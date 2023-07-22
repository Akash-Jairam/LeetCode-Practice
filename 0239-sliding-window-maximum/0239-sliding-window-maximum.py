from collections import deque
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        q = deque()
        l = 0
        
        for r in range(len(nums)):
            # Remove any numbers from the queue that are less than the curr one
            while q and nums[q[-1]] < nums[r]:
                q.pop()
                
            q.append(r)
            
            # Remove the left most value if left pointer is greater than left index
            if l > q[0]:
                q.popleft()
            
            if r + 1 >= k:
                res.append(nums[q[0]])
                l += 1
        
        return res
            
            
            