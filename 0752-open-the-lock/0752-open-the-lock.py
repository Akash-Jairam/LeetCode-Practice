from collections import deque
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        deadends = set(deadends)
        
        if target in deadends:
            return -1
        
        if "0000" in deadends:
            return -1
        
        level = 0
        
        q = deque(['0000'])
        
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if curr == target:
                    return level
                
                for i in range(4):
                    pre, post = curr[:i], curr[i+1:]
                    for op in [-1, 1]:
                        nxt = pre + str((int(curr[i]) + op) % 10) + post
                        if nxt not in deadends:
                            deadends.add(nxt)
                            q.append(nxt)
            level += 1
        
        return -1