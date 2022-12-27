class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        remaining_capacity = []
        
        for i in range(len(rocks)):
            remaining_capacity.append(capacity[i] - rocks[i])
        
        remaining_capacity.sort()
        full_bags = 0
        
        for curr_capacity in remaining_capacity:
            if additionalRocks >= curr_capacity:
                additionalRocks -= curr_capacity
                full_bags += 1
        
        return full_bags
        
        