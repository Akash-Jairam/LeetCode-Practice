"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        copy = {}
        
        def dfs(node):
            if node in copy:
                return copy[node]
            
            curr_copy = Node(node.val)
            copy[node] = curr_copy
            for n in node.neighbors:
                curr_copy.neighbors.append(dfs(n))
            return curr_copy
                
        dfs(node)
        return copy[node]