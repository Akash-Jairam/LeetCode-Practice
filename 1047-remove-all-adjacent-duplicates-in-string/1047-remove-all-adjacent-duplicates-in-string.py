class Solution:
    def removeDuplicates(self, s: str) -> str:
        res = []
        res.append(s[0])
        
        for i in range(1, len(s)):
            if res and res[-1] == s[i]:
                res.pop()
            else:
                res.append(s[i])
        
        return "".join(res)
        
        