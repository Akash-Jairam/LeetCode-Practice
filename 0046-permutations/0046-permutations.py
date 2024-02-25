class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums[::]]
        
        res = []
        
        for i in range(len(nums)):
            curr = nums.pop(0)
            perms = self.permute(nums)
            
            for p in perms:
                p.append(curr)
            
            res.extend(perms)
            nums.append(curr)
        
        return res