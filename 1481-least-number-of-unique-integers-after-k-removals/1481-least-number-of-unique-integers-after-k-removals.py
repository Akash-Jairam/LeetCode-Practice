class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        n_map = {}
        for n in arr:
            n_map[n] = 1 + n_map.get(n, 0)
        
        n = len(n_map.keys())
        for v in sorted(n_map.values()):
            k -= v
            if k < 0:
                break
            elif k > 0:
                n -=1
            else:
                n -= 1
                break
        
        return n
            