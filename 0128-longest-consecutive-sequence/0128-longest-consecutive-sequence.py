class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n_set = set()
        
        for n in nums:
            n_set.add(n)
            
        res = 0
        for n in nums:
            if n - 1 not in n_set:
                length = 1
                while n + length in n_set:
                    length += 1
                res = max(res, length)
        
        return res