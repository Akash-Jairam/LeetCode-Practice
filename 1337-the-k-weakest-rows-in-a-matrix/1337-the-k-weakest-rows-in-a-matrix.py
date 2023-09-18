import heapq
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        min_heap = []
        for i in range(len(mat)):
            total = sum(mat[i])
            heapq.heappush(min_heap, (-total, -i))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        
        min_heap.sort(key=lambda a: (a[0], a[1]))
        return [-p[1] for p in min_heap[::-1]]