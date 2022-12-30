from collections import deque
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        queue = deque()
        adjacency_matrix, res = {}, []
        final_dest = len(graph) -1
        for i in range(len(graph)):
            adjacency_matrix[i] = []
            for dest in graph[i]:
                adjacency_matrix[i].append(dest)
        
        queue.append([0, []])
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.pop()
                to_add = list(curr[1])
                to_add.append(curr[0])
                if curr[0] == final_dest:
                    res.append(to_add)
                    continue
                for dest in graph[curr[0]]:
                    queue.append([dest, to_add])
        
        return res
        
        
        
        
        