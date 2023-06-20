class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [-1] * n
        left, curr_sum, diameter = 0, 0, 2 * k + 1
        
        for right in range(n):
            curr_sum += nums[right]
            if right - left + 1 >= diameter:
                res[left + k] = curr_sum // diameter
                curr_sum -= nums[left]
                left += 1
        
        return res