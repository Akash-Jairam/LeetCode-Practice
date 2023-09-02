import heapq
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        n_map = {}
        for num in arr:
            n_map[num] = 1 + n_map.get(num, 0)
        
        vals = sorted(n_map.values())
        res = len(vals)
        for v in vals:
            if k >= v:
                k -= v
                res -= 1
            else:
                break
        
        return res