class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        dp = [0] * length
        
        for i in range(length):
            left_bed_av = i == 0 or flowerbed[i-1] == 0
            right_bed_av = i == length - 1 or flowerbed[i+1] == 0
            
            if left_bed_av and right_bed_av and flowerbed[i] == 0:
                if i == 1:
                    dp[i] = 1
                else:
                    prev_2 = 0 if i - 2 < 0 else dp[i-2]
                    prev_1 = 1 if i - 1 < 0 else dp[i-1]
                    dp[i] = max(prev_2 + 1, prev_1)
            else:
                dp[i] = dp[i-1]
        
        return dp[length-1] >= n