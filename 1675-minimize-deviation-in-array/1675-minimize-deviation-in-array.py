import heapq
class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        res, mn = math.inf, math.inf
        pq = []
        for num in nums:
            cur = -num if num % 2 == 0 else -num * 2
            heappush(pq, cur)
            mn = min(mn, -cur)

        while pq[0] % 2 == 0:
            res = min(res, -pq[0] - mn)
            mn = min(mn, -pq[0]//2)
            heappushpop(pq, pq[0]//2)
            
        return min(res, -pq[0] - mn)