class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        '''
            Sort the input array
            Backtrack
            Each time we backtrack,we either add the current number or skip the current number
            Skip the current number by incrementing the index until we encounter a number that is not the current number or we are out of bounds
        '''
        res = []
        nums.sort()
        self.backtrack(0, nums, [], res)
        return res
    
    def backtrack(self, i, nums, curr, res):
        if i == len(nums):
            res.append(curr[::])
            return
        
        curr.append(nums[i])
        self.backtrack(i + 1, nums, curr, res)
        curr.pop()
        
        while i + 1 < len(nums) and nums[i] == nums[i+1]:
            i += 1
        
        self.backtrack(i + 1, nums, curr, res)