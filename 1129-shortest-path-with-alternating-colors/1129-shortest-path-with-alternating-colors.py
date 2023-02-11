from collections import defaultdict, deque
class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        res = [float('inf')] * n
        adj_matrix = defaultdict(list)
        
        for k, v in redEdges:
            adj_matrix[k].append((v, 'red'))
        
        for k, v in blueEdges:
            adj_matrix[k].append((v, 'blue'))
        
        queue = deque()
        queue.append((0, ''))
        dist = 0
        visited = set()
        visited.add((0, ''))
        while queue:
            size = len(queue)
            for _ in range(size):
                i, color = queue.popleft()
                res[i] = min(res[i], dist)
                
                for dest, new_color in adj_matrix[i]:
                    if new_color != color and (dest, new_color) not in visited:
                        queue.append((dest, new_color))
                        visited.add((dest, new_color))
            dist += 1
        
        for i in range(len(res)):
            if res[i] == float('inf'):
                res[i] = -1
        return res
            