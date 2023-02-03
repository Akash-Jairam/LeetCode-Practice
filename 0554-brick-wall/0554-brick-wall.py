from collections import defaultdict
class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        n = len(wall)
        gap_map = defaultdict(int)
        
        for row in wall:
            width = 0
            for brick in row[:-1]:
                width += brick
                gap_map[width] += 1
        return n - max(gap_map.values()) if gap_map else n