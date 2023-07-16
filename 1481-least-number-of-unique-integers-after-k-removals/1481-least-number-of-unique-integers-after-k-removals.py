import heapq
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        # Use a map to track the numbers and their frequencies
        # Push the number and freq to a min heap
        # Decrease frequencies by popping from the heap until k is reduced to 0
        # If a frequency is not reduced to 0, put it back in the heap
        n_map = {}
        min_heap  = []
        for n in arr:
            n_map[n] = 1 + n_map.get(n, 0)
        
        for key, v in n_map.items():
            heapq.heappush(min_heap, (v, key))
        
        while k > 0:
            v, key = heapq.heappop(min_heap)
            if k >= v:
                k -= v
            else:
                v -= k
                k = 0
                heapq.heappush(min_heap, (v, key))
        return len(min_heap)