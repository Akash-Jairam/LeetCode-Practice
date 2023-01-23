from collections import defaultdict
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        num_map, threshold = defaultdict(int), len(nums) // 2
        
        for num in nums:
            num_map[num] += 1
            if num_map[num] > threshold:
                return num
        
        return -1