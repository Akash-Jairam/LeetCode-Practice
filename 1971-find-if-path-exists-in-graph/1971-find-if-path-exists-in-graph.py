from collections import deque
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        path_map = {}
        visited = set()
        for edge in edges:
            if edge[0] not in path_map:
                path_map[edge[0]] = []
            
            if edge[1] not in path_map:
                path_map[edge[1]] = []
            path_map[edge[0]].append(edge[1])
            path_map[edge[1]].append(edge[0])
        
        queue = deque()
        queue.append(source)
        
        while queue:
            size = len(queue)
            for i in range(size):
                curr_node = queue.popleft()
                visited.add(curr_node)
                if(curr_node == destination):
                    return True;
                
                if curr_node in path_map:
                    for node in path_map[curr_node]:
                        if node not in visited:
                            queue.append(node)
        
        return False
               
        