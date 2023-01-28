from collections import Counter
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_map = Counter(nums)
        min_heap = []
        
        for num, count in num_map.items():
            heapq.heappush(min_heap, [count, num])
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return [pair[1] for pair in min_heap]
            
        