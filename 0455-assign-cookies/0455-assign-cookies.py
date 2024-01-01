import heapq
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        heapq.heapify(s)
        res = 0
        for i in range(len(g)):
            while s and s[0] < g[i]:
                heapq.heappop(s)
            if s and s[0] >= g[i]:
                heapq.heappop(s)
                res += 1
        
        return res