from collections import deque
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        visited = set()
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
                to_add = [i for i in curr[1]]
                to_add.append(curr[0])
                visited.add(curr[0])
                for dest in graph[curr[0]]:
                    if dest == final_dest:
                        copy = [i for i in to_add]
                        copy.append(final_dest)
                        res.append(copy)
                    else:
                        queue.append([dest, to_add])
        
        return res
        
        
        
        
        