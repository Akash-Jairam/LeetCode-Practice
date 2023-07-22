from collections import deque
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # Use a queue to keep track of the max numbers at any given time
        # Pop off numbers from the right of the queue that are less than the # at the current index
        # Append the current index to the queue
        # If the left pointer is greater than the curr index, pop the left value
        # If we are within a window, we add the number at the front of the queue to the result array and increment the left pointer
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
            
            
            