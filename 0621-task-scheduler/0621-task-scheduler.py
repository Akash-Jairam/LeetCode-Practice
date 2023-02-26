from collections import Counter, deque
import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # Group the tasks by their count
        # Create a max heap to sort the tasks by highest count
        # Create a queue to hold the tasks that are waiting for their cooldown to finish
        # Use a while loop that continues while either the heap or queue has elements
        # Pop the current element from the heap, reduce the abs value by 1, if it is not 0, append to queue for cooldown
        # Check the queue and pop all elements whose cooldown are <= curr time and add them to heap for processing
        # Increment time
        # Return time once finished
        tasks_by_count = Counter(tasks)
        max_heap = [-count for count in tasks_by_count.values()]
        heapq.heapify(max_heap)
        queue = deque()
        time = 0
        
        while max_heap or queue:
            if max_heap:
                curr = heapq.heappop(max_heap)
                curr += 1
                if curr:
                    queue.append([curr, time + n])
            
            while queue and queue[0][1] <= time:
                heapq.heappush(max_heap, queue.popleft()[0])
            
            time += 1
        
        return time
        