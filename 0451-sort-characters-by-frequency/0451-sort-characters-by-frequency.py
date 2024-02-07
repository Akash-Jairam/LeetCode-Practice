import heapq
class Solution:
    def frequencySort(self, s: str) -> str:
        c_map = {}
        
        for c in s:
            c_map[c] = 1 + c_map.get(c, 0)
        
        max_heap = []
        for k, v in c_map.items():
            heapq.heappush(max_heap, (-v, k))
        
        res = []
        while max_heap:
            v,c = heapq.heappop(max_heap)
            res.append( c * -v)
        
        return ''.join(res)
        