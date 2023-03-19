from collections import defaultdict, deque
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        inDegree = [0] * numCourses
        c_map = defaultdict(list)
        numDependencies, edgesRemoved = 0, 0
        
        for a, b in prerequisites:
            inDegree[a] += 1
            c_map[b].append(a)
            numDependencies += 1
        
        queue = deque()
        for i in range(numCourses):
            if inDegree[i] == 0:
                queue.append(i)
        
        res = []
        if not queue:
            return res
        
        while queue:
            size = len(queue)
            for _ in range(len(queue)):
                curr = queue.popleft()
                res.append(curr)
                for c in c_map[curr]:
                    inDegree[c] -= 1
                    edgesRemoved += 1
                    if inDegree[c] == 0:
                        queue.append(c)
        
        return res if numDependencies == edgesRemoved else []