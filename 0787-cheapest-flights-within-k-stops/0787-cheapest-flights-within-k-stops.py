class Solution:
    def findCheapestPrice(self, N: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adj_list = defaultdict(list)
        for u,v,w in flights: adj_list[u].append((v,w))
        queue = deque([(0, src, k)])
        #Infinity
        price = [float(inf)] * N        
        while queue:
            cost, node, stops = queue.popleft()
            for nei,w in adj_list[node]:
                if cost + w < price[nei]:
                    price[nei] = cost + w
                    if stops > 0:
                        queue.append((cost + w, nei, stops - 1))
        
        return -1 if price[dst] == float(inf) else price[dst]