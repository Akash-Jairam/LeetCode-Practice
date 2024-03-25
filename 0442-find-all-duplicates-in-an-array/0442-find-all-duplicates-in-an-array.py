class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        n_map = [0] * (len(nums) + 1)
        res = []
        for num in nums:
            n_map[num] += 1
            if n_map[num] == 2:
                res.append(num)
        
        return res