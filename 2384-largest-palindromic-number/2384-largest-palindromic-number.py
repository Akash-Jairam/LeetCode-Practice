class Solution:
    def largestPalindromic(self, num: str) -> str:
        n_map = [0] * 10
        
        for c in num:
            n_map[int(c)] += 1
        
        odd = None        
        i = 9
        res = []
        while i >= 0:
            if n_map[i] > 0:
                if i == 0 and len(res) == 0:
                    break
                
                if n_map[i] % 2 == 1 and not odd:
                    odd = i
                numAppend = n_map[i] // 2
                if numAppend:
                    res.append(str(i) * numAppend)
            i -= 1
            
            if odd == None:
                odd = ''
        return "0" if len(res) == 0 and not odd else ''.join(res) + str(odd) + ''.join(res[::-1])
        