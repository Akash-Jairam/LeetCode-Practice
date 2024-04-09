from collections import deque
class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        
        q = deque([i for i in range(len(tickets))])
        time = 0
        while tickets[k]:
            curr = q.popleft()
            tickets[curr] -= 1
            if tickets[curr]:
                q.append(curr)
            time += 1
        
        return time