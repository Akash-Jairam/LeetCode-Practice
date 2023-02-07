class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        f_map = {}
        curr, res = 0, 0
        
        for i in range(len(fruits)):
            f = fruits[i]
            if f not in f_map and len(f_map) == 2:
                max_key = -1
                max_val = float('inf')
                min_key = -1
                for k, v in f_map.items():
                    if v < max_val:
                        max_val = v
                        max_key = k
                del f_map[max_key]
                curr = i - max_val
                f_map[f] = i
            else:
                f_map[f] = i
                curr += 1
            res = max(res, curr)
        
        return res