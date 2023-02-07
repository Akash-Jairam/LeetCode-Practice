from collections import deque
class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        queue = deque()
        doms = list(dominoes)
        
        for i, v in enumerate(dominoes):
            if v != '.':
                queue.append((i, v))
        
        while queue:
            i, v = queue.popleft()
            if v == 'L' and i > 0 and doms[i-1] == '.':
                doms[i-1] = 'L'
                queue.append((i - 1, 'L'))
            elif v == 'R':
                if i + 1 < len(doms) and doms[i+1] == '.':
                    if i + 2 < len(doms) and doms[i+2] == 'L':
                        queue.popleft()
                    else:
                        doms[i+1] = 'R'
                        queue.append((i+1, 'R'))
            
        
        return ''.join(doms)