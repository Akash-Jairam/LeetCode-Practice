class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        n_map = {}
        
        for i in range(len(nums)):
            if nums[i] not in n_map:
                n_map[nums[i]] = []
                
            indices = n_map[nums[i]]
            if len(indices) > 0:
                for idx in indices:
                    if i - idx <= k:
                        return True
            
            indices.append(i)
        
        return False