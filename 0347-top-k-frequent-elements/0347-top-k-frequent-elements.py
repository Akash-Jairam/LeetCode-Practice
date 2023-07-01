from collections import defaultdict
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n_map = defaultdict(int)
        for n in nums:
            n_map[n] += 1
            
        heap = []
        
        for num, v in n_map.items():
            heapq.heappush(heap, (v, num))
            
            
            while len(heap) > k:
                heapq.heappop(heap)
                
        return [num for v, num in heap]