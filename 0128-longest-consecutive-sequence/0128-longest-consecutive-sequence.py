class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        n_set = set()
        
        for n in nums:
            n_set.add(n)
            
        res = 0
        for n in nums:
            if n - 1 not in n_set:
                curr = 1
                while n + 1 in n_set:
                    curr += 1
                    n += 1
                res = max(res, curr)
        
        return res