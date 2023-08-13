class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parent = [i for i in range(n)]
        rank = [1 for i in range(n)]
        
        
        def find(node):
            p = parent[node]
            
            while p != parent[p]:
                parent[p] = parent[parent[p]]
                p = parent[p]
            
            return p
        
        def union(n1, n2):
            p1, p2 = find(n1), find(n2)
            
            if rank[p1] > rank[p2]:
                parent[p2] = p1
                rank[p1] += rank[p2]
            else:
                parent[p1] = p2
                rank[p2] += rank[p1]
        
        for n1, n2 in edges:
            union(n1, n2)
        
        res = set()
        for i in range(n):
            res.add(find(i))
        return len(res)
    