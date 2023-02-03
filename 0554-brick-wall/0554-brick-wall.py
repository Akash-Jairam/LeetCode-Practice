from collections import defaultdict
class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        n = len(wall)
        gap_map = defaultdict(int)
        
        for row in wall:
            width = 0
            for brick in row:
                width += brick
                gap_map[width] += 1
        del gap_map[sum(wall[0])]
        return n - max(gap_map.values()) if gap_map else n