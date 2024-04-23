from collections import deque
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            return [i for i in range(n)]
        adj_list = [set() for i in range(n)]
        
        for x,y in edges:
            adj_list[x].add(y)
            adj_list[y].add(x)
            
        q = []
        for i in range(n):
            if len(adj_list[i]) == 1:
                q.append(i)
        
        rem = n
        
        while rem > 2:
            rem -= len(q)
            new_leaves = []
            
            while q:
                curr = q.pop()
                neighbor = adj_list[curr].pop()
                adj_list[neighbor].remove(curr)
                if len(adj_list[neighbor]) == 1:
                    new_leaves.append(neighbor)
            q = new_leaves
        
        return q