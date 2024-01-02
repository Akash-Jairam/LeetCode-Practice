from collections import defaultdict
class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        n_map = [0] * 201
        res = {}
        for n in nums:
            idx = n_map[n]
            if idx not in res:
                res[idx] = []
            res[idx].append(n)
            n_map[n] += 1
        
        
        
        return res.values()