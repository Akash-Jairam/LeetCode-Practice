class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n_map = {}
        res = 0
        for n in nums:
            n_map[n] = 1 + n_map.get(n, 0)
        
        for n, count in n_map.items():
            if count == 1:
                return -1
            
            res += ceil(count / 3)
        
        return res
            
            