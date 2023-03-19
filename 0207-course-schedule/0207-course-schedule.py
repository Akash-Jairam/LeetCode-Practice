from collections import deque, defaultdict
class Solution:
    def canFinish(self, numCourses: int, prereqs: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        c_map = defaultdict(list)
        for a, b in prereqs:
            inDegree[a] += 1
            c_map[b].append(a)
        
        queue = deque()
            
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)
                
        if not queue:
            return False
        
        completed = set()
        while queue:
            size = len(queue)
            for _ in range(size):
                curr  = queue.popleft()
                completed.add(curr)
                for c in c_map[curr]:
                    inDegree[c] -= 1
                    if inDegree[c] == 0:
                        queue.append(c)
        
        for c in inDegree:
            if c > 0:
                return False
        
        return True
                