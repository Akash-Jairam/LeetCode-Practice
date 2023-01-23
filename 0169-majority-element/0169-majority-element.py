from collections import defaultdict
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        num_map, threshold = defaultdict(int), len(nums) // 2
        
        for num in nums:
            num_map[num] += 1
        
        for key, value in num_map.items():
            if value > threshold:
                return key
        
        return -1