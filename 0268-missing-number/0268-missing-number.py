class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        curr = 0
        expected = 0
        actual = 0
        for i in range(len(nums)):
            actual += nums[i]
            expected += curr
            curr += 1
        
        expected += curr
        return abs(expected - actual)