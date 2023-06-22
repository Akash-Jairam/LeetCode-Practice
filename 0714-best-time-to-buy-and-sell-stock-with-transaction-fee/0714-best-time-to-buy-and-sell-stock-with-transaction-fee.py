class Solution:
    def maxProfit(self, prices, fee):
        soldi = 0
        buyi = -prices[0]
        for i in range(1, len(prices)):
            prevBuyi = buyi
            buyi = max(buyi, soldi - prices[i])
            soldi = max(soldi, prevBuyi + prices[i] - fee)
        return soldi
