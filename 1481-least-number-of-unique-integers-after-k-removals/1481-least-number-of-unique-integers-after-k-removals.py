import heapq
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        n_map = {}
        max_heap = []
        for n in arr:
            n_map[n] = 1 + n_map.get(n, 0)
        
        for key, v in n_map.items():
            heapq.heappush(max_heap, (v, key))
        
        while k > 0:
            v, key = heapq.heappop(max_heap)
            if k >= v:
                k -= v
            else:
                v -= k
                k = 0
                heapq.heappush(max_heap, (v, key))
        return len(max_heap)