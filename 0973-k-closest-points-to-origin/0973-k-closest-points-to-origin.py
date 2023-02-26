import heapq
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_heap = []
        
        for x, y in points:
            heapq.heappush(min_heap, [-(x**2 + y ** 2) ** (0.5), [x,y]])
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        return [dist[1] for dist in min_heap]