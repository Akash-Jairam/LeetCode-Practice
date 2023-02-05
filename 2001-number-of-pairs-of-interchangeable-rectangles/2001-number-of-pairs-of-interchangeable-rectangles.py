from collections import defaultdict
class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        ratio_map = defaultdict(int)
        num_pairs = 0
        for x, y in rectangles:
            ratio_map[x/y] += 1
            
            
        
        for val in ratio_map.values():
            for i in range(val):
                num_pairs += (val - i - 1)
        
        return num_pairs