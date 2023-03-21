class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        numConsecZeroes = 0
        res = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                numConsecZeroes += 1
            else:
                numConsecZeroes = 0
            res += numConsecZeroes
            
        
        return res