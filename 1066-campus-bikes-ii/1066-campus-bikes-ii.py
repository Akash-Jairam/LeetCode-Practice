class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> int:
        def dis(i, j):
            """
            i --> ith worker
            j --> jth worker
            """
            return abs(workers[i][0] - bikes[j][0]) + abs(workers[i][1] - bikes[j][1])
        
        # dist, i, taken_state
        q = [(0, 0, 0)]     
        seen = set()
        
        while q:
            dist, i, taken_state = heapq.heappop(q)
            
            if (i, taken_state) in seen: continue
            seen.add((i, taken_state))
            
            if i == len(workers):
                return dist
            
            # go through all bikes
            for j in range(len(bikes)):
                # bike not taken
                if taken_state & (1 << j) == 0:
                    cost = dis(i, j)
                    new_taken = taken_state | 1 << j        # take the jth bike
                    heapq.heappush(q, (cost + dist, i + 1, new_taken))