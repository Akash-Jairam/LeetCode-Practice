class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # Copy nums to our result array
        # Create a variable to track our right product
        # Iterate from right to left
        # Update res[i] to the product of res[i] and right product
        # Multiply right product by nums[i]
        n = len(nums)
        res = [1] * n
        res[0] = 1
        
        for i in range(1, n):
            res[i] = res[i-1] * nums[i-1]
        
        r_prod = 1
        
        for i in range(n - 1, -1, -1):
            res[i] *= r_prod
            r_prod *= nums[i]
        
        return res