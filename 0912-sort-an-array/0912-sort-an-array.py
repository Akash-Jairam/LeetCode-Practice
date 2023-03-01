class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        min_val, max_val = float('inf'),  float('-inf')
        num_map = {}
        res = []
        for num in nums:
            min_val = min(min_val, num)
            max_val = max(max_val, num)
            num_map[num] = num_map.get(num, 0) + 1
        
        for i in range(min_val, max_val + 1, 1):
            if num_map.get(i, 0):
                res.extend([i] * num_map[i])
        
        return res