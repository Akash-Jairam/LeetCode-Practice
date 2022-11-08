class Solution:
    def makeGood(self, s: str) -> str:
        res = []
        res.append(s[0])
        n = len(s)
        
        for i in range(1, n):
            prev = None
            if len(res) > 0:
                prev = res[len(res) - 1]
            if prev != None and prev != s[i] and prev.upper() == s[i].upper():
                res.pop()
            else:
                res.append(s[i])
        
        return "".join(res)