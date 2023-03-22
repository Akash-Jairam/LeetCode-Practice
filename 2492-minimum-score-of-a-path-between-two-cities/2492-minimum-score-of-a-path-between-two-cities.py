from collections import deque, defaultdict
class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
         # construct graph
        graph = defaultdict(list)
        for node1, node2, cost in roads:
            graph[node1].append((node2, cost))
            graph[node2].append((node1, cost))
        # bfs or dfs
        res = float("inf")
        queue = deque()
        queue.append(1)
        visited = set()
        visited.add(1)
        while queue:
            node = queue.popleft()
            for next_node, c in graph[node]:
                res = min(res, c)
                if next_node not in visited:
                    visited.add(next_node)
                    queue.append(next_node)
        return res