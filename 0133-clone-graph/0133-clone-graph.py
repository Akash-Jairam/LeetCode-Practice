"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
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
        