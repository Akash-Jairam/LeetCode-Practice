from collections import defaultdict
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        rem_map = defaultdict(int)
        rem_map[0] = 1
        curr_sum = 0
        res = 0
        
        for num in nums:
            curr_sum += num
            remainder = abs(curr_sum % k)
            res += rem_map[remainder]
            rem_map[remainder] += 1
            
        return res
            