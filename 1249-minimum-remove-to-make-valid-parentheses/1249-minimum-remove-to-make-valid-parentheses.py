class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        deleted = set()
        
        numOpen, numClosed = 0, 0
        res = []
        lastOpen = []
        for i in range(len(s)):
            c = s[i]
            if c == '(':
                numOpen += 1
                lastOpen.append(i)
            elif c == ')':
                if numClosed < numOpen:
                    numClosed += 1
                else:
                    deleted.add(i)
                
        while lastOpen and numOpen > numClosed:
            numOpen -= 1
            deleted.add(lastOpen[-1])
            lastOpen.pop()
        
        for i in range(len(s)):
            if i not in deleted:
                res.append(s[i])
        
        return ''.join(res)
        
        
                    
                    
    