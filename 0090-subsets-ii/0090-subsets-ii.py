class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        
        def backtrack(idx, curr):
            if idx == len(nums):
                res.append(curr[::])
                return
            
            curr.append(nums[idx])
            backtrack(idx + 1, curr)
            curr.pop()
            
            while idx < len(nums) - 1 and nums[idx] == nums[idx + 1]:
                idx += 1
            
            backtrack(idx + 1, curr)
        
        backtrack(0, [])
        return res