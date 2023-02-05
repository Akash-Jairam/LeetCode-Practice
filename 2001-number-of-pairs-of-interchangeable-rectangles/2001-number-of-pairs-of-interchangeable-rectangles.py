from collections import defaultdict
class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        # Use a map to keep track of all the rectangles with the same ratio
        # Use the combination formula to get the number of combinations for a given ratio
        # (n!) / ((n - k!) * k!) 
        # where n is the count for a given ratio and k is the size of an individual combo (2 in this case)
        ratio_map = defaultdict(int)
        num_pairs = 0
        for w, h in rectangles:
            ratio_map[w/h] += 1
            
            
        
        for val in ratio_map.values():
            if val > 1:
                num_pairs += math.factorial(val) // (math.factorial(val - 2) * math.factorial(2))
        
        return num_pairs