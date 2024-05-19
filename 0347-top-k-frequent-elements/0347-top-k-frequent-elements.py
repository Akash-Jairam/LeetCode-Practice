import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n_map = {}
        
        for n in nums:
            n_map[n] = 1 + n_map.get(n, 0)
        
        min_heap = []
        for key, v in n_map.items():
            heapq.heappush(min_heap, (v, key))
            while len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return [t[1] for t in min_heap]