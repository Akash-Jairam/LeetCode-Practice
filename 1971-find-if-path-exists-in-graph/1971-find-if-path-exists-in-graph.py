class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        uf = UnionFind(n)
        for x, y in edges:
            uf.union(x, y)
        
        parent = uf.parent
        return uf.find(source) == uf.find(destination)

class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.hier = [1] * n
    
    def union(self, x, y):
        p1, p2 = self.find(x), self.find(y)
        if p1 != p2:
            if self.hier[p1] > self.hier[p2]:
                self.parent[p2] = p1
                self.hier[p1] += self.hier[p2]
            else:
                self.parent[p1] = p2
                self.hier[p2] += self.hier[p1]
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
        
        return node