class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n

    def findAP(self, curr) :
        if self.parent[curr] == curr :  
            return curr
        self.parent[curr] = self.findAP(self.parent[curr])  
        return self.parent[curr]

    def union(self, u, v) :
        uap = self.findAP(u)
        vap = self.findAP(v)
        if uap == vap : 
            return False
        if self.size[uap] > self.size[vap]:
            uap , vap = vap, uap
        self.parent[uap] = vap
        self.size[vap] += self.size[uap]  

class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:        
        n = len(vals)

        adjList = defaultdict(list)
        for u, v in edges:
            adjList[v].append(u)
            adjList[u].append(v)

        valNodes = defaultdict(list)
        for i in range(n):
            valNodes[vals[i]].append(i)
        
        uf = UnionFind(n)
                
        res = n
        for val in sorted(valNodes):
            for curr in valNodes[val]:
                for adj in adjList[curr]:
                    if vals[adj] <= vals[curr]:
                        uf.union(curr, adj) # add edges with smaller/equal val
            
            group = defaultdict(int)  # no of different groups for curr valNodes
            for curr in valNodes[val]:
                group[uf.findAP(curr)] += 1
                
            for _, cnt in group.items():
                if cnt >= 2:        # more than 1 same val nodes in same group 
                    res += cnt * (cnt - 1) // 2
        return res