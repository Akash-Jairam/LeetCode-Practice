from collections import deque
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # Use a queue where the idx of highest number is the first element 
        # Pop elements whenever the curr number is greater than elements at the back of the queue
        # Append the max element to res
        queue = deque()
        l, r, res = 0,0, []
        
        while r < len(nums):
            while queue and nums[queue[-1]] < nums[r]:
                queue.pop()
                
            queue.append(r)
            
            if l > queue[0]:
                queue.popleft()
            
            if r + 1 >= k:
                res.append(nums[queue[0]])
                l += 1
            
            r += 1
        return res