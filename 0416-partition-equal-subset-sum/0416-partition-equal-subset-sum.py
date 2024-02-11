class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2 != 0:
            return False
        
        target //= 2
        totals = set([0])
        
        for num in nums:
            tmp = set()
            for total in totals:
                tmp.add(total + num)
            
            totals.update(tmp)
            if target in totals:
                return True
        
        return False