import heapq
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        t_map = {}
        
        for t in tasks:
            t_map[t] = 1 + t_map.get(t, 0)
            
        max_heap = []
        for k,v in t_map.items():
            heapq.heappush(max_heap, (-v, k))
        
        min_heap = []
        time = 0
        
        while max_heap or min_heap:
            if max_heap:
                count, task = heapq.heappop(max_heap)
                count = -count
                if count - 1:
                    heapq.heappush(min_heap, (time + n, count - 1, task))

            while min_heap and min_heap[0][0] <= time:
                curr_t, count, task = heapq.heappop(min_heap)
                heapq.heappush(max_heap, (-count, task))
            
            time += 1
        
        return time
                