class Solution:
    def largestPalindromic(self, num: str) -> str:
        n_map = [0] * 10
        
        for n in num:
            n_map[int(n)] += 1
        
        i = 9
        half = []
        mid = ''
        while i >= 0:
            if i == 0 and not len(half):
                break
            
            if n_map[i] % 2 == 1 and not mid:
                mid = str(i)
            
            if n_map[i] > 1:
                half.append(str(i) * (n_map[i] // 2))
            i -= 1
        
        if not mid and not len(half):
            return "0"
        return ''.join(half) + mid + ''.join(half[::-1])