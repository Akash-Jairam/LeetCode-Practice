class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        oneAhead,twoAhead = 0, 0
        
        idx = len(cost) - 1
        
        while idx >= 0:
            curr = cost[idx] + min(oneAhead, twoAhead)
            twoAhead = oneAhead
            oneAhead = curr
            idx -= 1
        
        return min(oneAhead, twoAhead)