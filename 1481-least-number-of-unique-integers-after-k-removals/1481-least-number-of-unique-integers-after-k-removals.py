import heapq
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        n_map = {}
        for num in arr:
            n_map[num] = 1 + n_map.get(num, 0)
        
        min_heap = [[v, k]for k,v in n_map.items()]
        heapq.heapify(min_heap)
        while k > 0:
            curr = heapq.heappop(min_heap)
            curr[0] -= 1
            if curr[0] > 0:
                heapq.heappush(min_heap, curr)
            k -= 1
        return len(min_heap)
