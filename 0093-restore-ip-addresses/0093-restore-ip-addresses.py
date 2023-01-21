class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        def backtrack(s, count, curr, rst):
            if count == 4:
                if not s: rst.append(curr[:-1])
                return
            
            
            for i in range(1, 4):
                if i > len(s):
                    continue
                
                if i > 1 and s[0] == '0':
                    continue
                
                if i > 2 and int(s[:3]) > 255: continue
                
                backtrack(s[i:], count + 1, curr + s[:i] +'.', rst)
            
        
        res = []
        backtrack(s, 0, '', res)
        return res