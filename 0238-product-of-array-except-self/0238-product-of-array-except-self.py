class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prev = 1
        leftProd, rightProd = [], [0] * len(nums)
        
        for i in range(len(nums)):
            prev *= nums[i]
            leftProd.append(prev)
        
        
        prev = 1
        i = len(nums) - 1
        while i >= 0:
            prev *= nums[i]
            rightProd[i] = prev
            i -= 1
        
        
        res = [rightProd[1]]
        
        for i in range(1, len(nums) - 1):
            res.append(leftProd[i-1] * rightProd[i+1])
        
        res.append(leftProd[len(nums) -2])
        return res