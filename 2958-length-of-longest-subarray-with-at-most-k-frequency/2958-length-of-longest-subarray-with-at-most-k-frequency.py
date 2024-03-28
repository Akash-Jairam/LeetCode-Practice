class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        l = 0
        n_map = {}
        
        res = 0
        
        for r in range(len(nums)):
            c = nums[r]
            n_map[c] = 1 + n_map.get(c, 0)
            while n_map[c] > k:
                n_map[nums[l]] -= 1
                l += 1
            
            res = max(res, r - l + 1)
        
        return res