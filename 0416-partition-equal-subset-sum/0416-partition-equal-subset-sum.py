class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        target = sum(nums)
        if target % 2 == 1:
            return False
        target //= 2
        sum_set = set([0])
        
        for i in range(len(nums)):
            curr_list = []
            for num in sum_set:
                curr_list.append(nums[i] + num)
            
            sum_set.update(curr_list)
            if target in sum_set:
                return True
        
        return False