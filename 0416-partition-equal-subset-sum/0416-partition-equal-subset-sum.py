class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2 == 1:
            return False
        
        target //= 2
        sum_set = set([0])
        
        for num in nums:
            tmp = set()
            for n2 in sum_set:
                tmp.add(num + n2)
            sum_set.update(tmp)
            if target in sum_set:
                return True
        
        return False