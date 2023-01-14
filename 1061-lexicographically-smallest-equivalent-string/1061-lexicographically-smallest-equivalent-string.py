class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        '''
        step1: model these equalities as edges in a graph
        step2: compute connected components of the graph ==> {node: commID}
        step3: convert 's'
        '''
        d = {i:i for i in string.ascii_lowercase}
        
        def find(i):
            if d[i] != i:
                return find(d[i])
            return d[i]
        
        
        def union(x, y):
            x_parent = find(x)
            y_parent = find(y)
            
            if d[x_parent] < d[y_parent]:
                d[y_parent] = x_parent
            else:
                
                d[x_parent] = y_parent
        
        
        for a, b in zip(s1, s2):
            union(a, b)
        
        ans = ''
        for c in baseStr:
            ans += find(c)
            
        return ans