from collections import defaultdict
class Solution:
     def minReorder(self, n: int, connections: List[List[int]]) -> int:
        RG = collections.defaultdict(list)
        NG = collections.defaultdict(list)
        for x, y in connections:
            RG[y] += x,
            NG[x] += y,
            
        def dfs(v, seen):
            seen.add(v)
            ans = 0
            
            for w in RG[v]:
                if w not in seen:
                    ans += dfs(w, seen)
                    
            for w in NG[v]:
                if w not in seen:
                    ans += 1 + dfs(w, seen)
                    
            return ans
        
        return dfs(0, set())