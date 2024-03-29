"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        # We use the dfs to return a copy of a given node complete with a copy of its neighbors
        # TC: O(N + M)
        # SC: O(N)
        copies = {}
        
        def dfs(node):
            if node in copies:
                return copies[node]
            
            copy = Node(node.val)
            copies[node] = copy
            for n in node.neighbors:
                copy.neighbors.append(dfs(n))
            
            return copy
        
        if node:
            dfs(node)
            return copies[node]
        