class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        largest = max(nums)
        n_map = [0] * (largest + len(nums))
        
        for i in range(len(nums)):
            n_map[nums[i]] += 1
        
        res = 0
        for i in range(len(n_map)):
            if n_map[i] > 1 and i < len(n_map) - 1:
                n_map[i+1] += n_map[i] - 1
                res += n_map[i]-1
                n_map[i] = 1

        return res