class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        parents = [i for i in range(n + 1)]
        rank = [1] * (n+1)
        
        
        def find(x):
            p = parents[x]
            
            while p != parents[p]:
                parents[p] = parents[parents[p]]
                p = parents[p]
            
            return p
        
        def union(x, y):
            p1, p2 = find(x), find(y)
            
            if p1 == p2:
                return False
            if rank[p1] > rank[p2]:
                parents[p2] = p1
                rank[p1] += rank[p2]
            else:
                parents[p1] = p2
                rank[p2] += rank[p1]
            
            return True
        
        for x, y in edges:
            if not union(x, y):
                return [x,y]
        