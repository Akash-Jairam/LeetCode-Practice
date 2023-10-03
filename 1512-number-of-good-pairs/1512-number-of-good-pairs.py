class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        n_map = {}
        res = 0
        for num in nums:
            res += n_map.get(num, 0)
            n_map[num] = 1 + n_map.get(num, 0)
        
        return res