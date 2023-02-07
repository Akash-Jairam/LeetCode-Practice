from collections import deque
class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        queue = deque()
        doms = list(dominoes)
        
        for i, v in enumerate(doms):
            if v != '.':
                queue.append((i, v))
        
        while queue:
            i, v = queue.popleft()
            
            if v == 'L' and i > 0 and doms[i-1] == '.':
                queue.append((i-1, 'L'))
                doms[i-1] = 'L'
            elif v == 'R':
                if i + 1 < len(doms) and doms[i+1] == '.':
                    # If standing dom is in between left and right like 'R.L', don't add to queue
                    if i + 2 < len(doms) and doms[i+2] == 'L':
                        queue.popleft()
                    else:
                        queue.append((i+1, 'R'))
                        doms[i+1] = 'R'
        return ''.join(doms)
                    