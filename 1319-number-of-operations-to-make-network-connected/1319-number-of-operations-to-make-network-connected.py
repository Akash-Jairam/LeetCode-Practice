class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        p = {}
        def find(x):
            p.setdefault(x, x)
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            p[find(x)] = find(y)
            
        for a, b in connections:
            union(a, b)
            
        k, t = len(set(map(find, range(n)))) - 1, len(connections)
        r = t - (n - k - 1)
        return k if r >= k else -1