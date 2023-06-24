from collections import defaultdict
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        n_map = defaultdict(int)
        
        for num in nums:
            if n_map[num]:
                return True
            n_map[num] += 1
        
        return False