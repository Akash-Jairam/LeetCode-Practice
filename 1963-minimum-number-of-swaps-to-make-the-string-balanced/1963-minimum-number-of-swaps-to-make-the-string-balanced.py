class Solution:
    def minSwaps(self, s: str) -> int:
        num_close, max_close = 0, 0
        
        for c in s:
            if c == '[':
                num_close -= 1
            else:
                num_close += 1
            
            max_close = max(max_close, num_close)
        
        return (max_close + 1) // 2