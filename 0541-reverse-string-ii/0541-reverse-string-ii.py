class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        n = len(s)
        split = list(s)
        i = 0
        
        while i < n:
            tmp = i
            j = min(i + k - 1, n - 1)
            while tmp < j:
                split[tmp], split[j] = split[j], split[tmp]
                tmp += 1
                j -= 1
            i += k * 2
        
        return ''.join(split)