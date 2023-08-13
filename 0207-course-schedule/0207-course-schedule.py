from collections import defaultdict, deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        c_map = defaultdict(list)
        inDegree = [0] * numCourses
        
        for post, pre in prerequisites:
            inDegree[post] += 1
            c_map[pre].append(post)
        
        zeroDegree = deque()
        for i in range(len(inDegree)):
            if inDegree[i] == 0:
                zeroDegree.append(i)
        
        if len(zeroDegree) == 0:
            return False
        
        while zeroDegree:
            size = len(zeroDegree)
            for _ in range(size):
                curr = zeroDegree.popleft()
                for post in c_map[curr]:
                    inDegree[post] -= 1
                    if inDegree[post] == 0:
                        zeroDegree.append(post)
        
        for i in range(numCourses):
            if inDegree[i] != 0:
                return False
        
        return True