
class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        n = len(parent)
        adj_matrix = [[] for _ in range(n)]
        
        for i in range(1, n):
            adj_matrix[parent[i]].append(i)
        
        res = [0]
        
        def dfs(node):
            curr_paths = [0]
            
            for child in adj_matrix[node]:
                path = dfs(child)
                if s[node] != s[child]:
                    curr_paths.append(path)
            
            curr_paths = nlargest(2, curr_paths)
            res[0] = max(res[0], sum(curr_paths) + 1)
            return max(curr_paths) + 1
        
        dfs(0)
        return res[0]
            
            
            
            