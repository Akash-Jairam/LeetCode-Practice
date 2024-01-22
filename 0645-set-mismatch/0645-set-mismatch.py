class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n_map = [0] * (len(nums) + 1)
        
        for i in range(len(nums)):
            n_map[nums[i]] += 1
        
        zero, one = 0, 0
        for i in range(1, len(n_map)):
            if n_map[i] == 0:
                one = i
            
            if n_map[i] > 1:
                zero = i
        
        return [zero, one]