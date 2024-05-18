class Solution:
    def largestPalindromic(self, num: str) -> str:
        half = []
        mid = ''
        n_map = [0] * 10
        
        for c in num:
            n_map[int(c)] += 1
        
        idx = 9
        
        while idx >= 0:
            if not len(half) and idx == 0:
                break
            
            if not mid and n_map[idx] % 2 == 1:
                mid = str(idx)
            
            if n_map[idx] // 2 > 0:
                half.append(str(idx) * (n_map[idx] // 2))
        
            idx -= 1
        
        return ''.join(half) + mid + ''.join(half[::-1]) if len(half) or mid else "0"