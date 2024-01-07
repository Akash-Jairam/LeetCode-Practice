class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        n_map = {}
        
        for i in range(len(nums)):
            n = nums[i]
            if n in n_map and i - n_map[n] <= k:
                return True
            
            n_map[n] = i
        return False