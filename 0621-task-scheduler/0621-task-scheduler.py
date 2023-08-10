from collections import deque
import heapq
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        t_map = {}
        for t in tasks:
            t_map[t] = 1 + t_map.get(t, 0)
            
        max_heap = [-count for count in t_map.values()]
        heapq.heapify(max_heap)
        
        q = deque()
        time = 0
        
        while q or max_heap:
            time += 1
            
            if not max_heap:
                time = q[0][1]
                
            if max_heap:
                count = 1 + heapq.heappop(max_heap)
                if count:
                    q.append([count, time + n])
            
            if q and q[0][1] == time:
                heapq.heappush(max_heap, q.popleft()[0])
        
        return time