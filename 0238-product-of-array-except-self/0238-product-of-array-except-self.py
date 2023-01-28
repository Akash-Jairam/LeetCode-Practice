class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #Use arrays to track the left product and right product
        n = len(nums)
        left_prod, right_prod = [1] * n, [1] * n
        res = []
        start, end = 1, n - 2
        left_prod[0] = nums[0]
        right_prod[-1] = nums[-1]
        
        while start < n and end >= 0:
            left_prod[start] = nums[start] * left_prod[start - 1]
            right_prod[end] = nums[end] * right_prod[end + 1]
            start += 1
            end -= 1
            
        for i in range(n):
            curr_prod = 1
            if i - 1 >= 0:
                curr_prod *= left_prod[i-1]
            
            if i + 1 < n:
                curr_prod *= right_prod[i+1]
            
            res.append(curr_prod)
        
        return res