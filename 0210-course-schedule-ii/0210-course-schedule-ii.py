from collections import deque, defaultdict
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        inDegree = [0] * numCourses
        c_map = defaultdict(list)
        
        
        for post, pre in prerequisites:
            inDegree[post] += 1
            c_map[pre].append(post)
        
        completed = []
        zeroDegree = deque()
        
        for i in range(numCourses):
            if inDegree[i] == 0:
                zeroDegree.append(i)
        
        if len(zeroDegree) == 0:
            return completed
        
        while zeroDegree:
            size = len(zeroDegree)
            for _ in range(size):
                curr = zeroDegree.popleft()
                completed.append(curr)
                for post in c_map[curr]:
                    inDegree[post] -= 1
                    if inDegree[post] == 0:
                        zeroDegree.append(post)
        
        for i in range(numCourses):
            if inDegree[i] != 0:
                return []
            
        return completed
        