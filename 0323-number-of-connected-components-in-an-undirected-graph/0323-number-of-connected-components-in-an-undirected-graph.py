class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        rank = [1] * n
        parent = [i for i in range(n)]
        
        
        def find(x):
            p = parent[x]
            
            while p != parent[p]:
                parent[p] = parent[parent[p]]
                p = parent[p]
            
            return p
        
        def union(x,y):
            p1, p2 = find(x), find(y)
            
            if rank[p1] < rank[p2]:
                parent[p1] = p2
                rank[p2] += rank[p1]
            else:
                parent[p2] = p1
                rank[p1] += rank[p2]
                
        for x, y in edges:
            union(x, y)
        
        
        return len(set(find(x) for x in range(n)))
            
            