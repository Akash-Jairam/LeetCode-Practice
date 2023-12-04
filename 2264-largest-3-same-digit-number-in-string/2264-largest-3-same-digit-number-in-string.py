class Solution:
    def largestGoodInteger(self, num: str) -> str:
        max_n = -1
        max_s = ""
        for i in range(0, len(num) - 2):
            if num[i] == num[i+1] == num[i+2]:
                if max_n < int(num[i] * 3):
                    max_n = int(num[i] * 3)
                    max_s = num[i] * 3
        
        return max_s