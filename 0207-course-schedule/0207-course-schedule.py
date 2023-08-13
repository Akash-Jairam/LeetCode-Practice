from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        
        for post, pre in prerequisites:
            inDegree[post] += 1
        
        zeroDegree = deque()
        for i in range(numCourses):
            if inDegree[i] == 0:
                zeroDegree.append(i)
        
        if len(zeroDegree) == 0:
            return False
        
        completed = set()
        numCompleted = 0
        while zeroDegree:
            size = len(zeroDegree)
            for _ in range(size):
                curr = zeroDegree.popleft()
                for post, pre in prerequisites:
                    if pre == curr:
                        inDegree[post] -= 1
                        if inDegree[post] == 0:
                            zeroDegree.append(post)
        
        for i in range(len(inDegree)):
            if inDegree[i] != 0:
                return False
            
        return True