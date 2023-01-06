class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        res, idx = 0, 0
        costs.sort()
        
        while coins > 0 and idx < len(costs):
            diff = coins - costs[idx]
            if diff >= 0:
                res += 1
                coins = diff
            idx += 1
        
        return res