import heapq
class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        ladder_alloc = []
        
        for i in range(len(heights) - 1):
            climb = heights[i+1] - heights[i]
            
            if climb <= 0:
                continue
            
            heapq.heappush(ladder_alloc, climb)
            if len(ladder_alloc) <= ladders:
                continue
            
            bricks -= heapq.heappop(ladder_alloc)
            if bricks < 0:
                return i
        
        return len(heights) - 1
                    