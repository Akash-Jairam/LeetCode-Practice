from collections import deque
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        steps = 0
        queue = deque()
        queue.append(start)
        
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr in bank:
                    bank.remove(curr)
                if curr == end:
                    return steps
                for cand in bank:
                    if self.isNext(curr, cand) and cand not in queue:
                        queue.append(cand)
            
            steps += 1
        
        return -1
    
    def isNext(self, curr, cand):
        i, j, numDiff = 0, 0, 0
        while i < len(curr) and j < len(cand) and numDiff <= 1:
            if curr[i] != cand[j]:
                numDiff += 1
            i += 1
            j += 1
        
        return numDiff == 1
        
        