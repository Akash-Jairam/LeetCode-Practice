class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        totalCosts = 0
        refunds = []
        
        for c1, c2 in costs:
            totalCosts += c1
            refunds.append(c2 - c1)
            
        refunds.sort()
        
        for i in range(len(refunds) // 2):
            totalCosts += refunds[i]
        
        return totalCosts