import heapq
class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        res = 0
        min_heap = []
        for i in range(len(colors) - 1):
            if colors[i] != colors[i+1]:
                heapq.heappush(min_heap, neededTime[i])
                while len(min_heap) > 1:
                    res += heapq.heappop(min_heap)
                min_heap = []
            else:
                heapq.heappush(min_heap, neededTime[i])
        
        heapq.heappush(min_heap, neededTime[-1])

        while len(min_heap) > 1:
            res += heapq.heappop(min_heap)
        return res
                
            
            
            