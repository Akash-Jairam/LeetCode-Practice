from collections import Counter, deque
import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
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
        