from collections import defaultdict
class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        n_map = [0] * 201
        
        for n in nums:
            n_map[n] += 1
        
        idx = 0
        toConvert = defaultdict(list)
        
        for i in range(len(n_map)):
            for j in range(n_map[i]):
                toConvert[j].append(i)
        
        return toConvert.values()