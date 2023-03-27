class Uf:
    
    def __init__(self, n):
        self.rank = [1] * n
        self.parent = [i for i in range(n)]
        
    def find(self, x):
        p = self.parent[x]
        
        while p != self.parent[p]:
            self.parent[p] = self.parent[self.parent[p]]
            p = self.parent[p]
        
        return p
    
    def union(self, x, y):
        p1, p2 = self.find(x), self.find(y)
        
        if p1 == p2:
            return False
        
        if self.rank[p1] > self.rank[p2]:
            self.parent[p2] = self.parent[p1]
            self.rank[p1] += self.rank[p2]
        else:
            self.rank[p2] += self.rank[p1]
            self.parent[p1] = self.parent[p2]
            
        return True
        
class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # A valid tree will have n - 1 edges and no cycles
        if len(edges) != n - 1:
            return False 
        
        uf = Uf(n)
        
        for x, y in edges:
            if not uf.union(x, y):
                return False
            
        return True
            
        
        