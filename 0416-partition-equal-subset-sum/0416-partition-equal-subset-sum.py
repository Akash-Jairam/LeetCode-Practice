class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        total = sum(nums)
        target = total // 2
        if total % 2 == 1:
            return False
        
        sum_set = set([0])
        
        for i in range(len(nums) - 1, -1, -1):
            curr_list = []
            for num in sum_set:
                curr_list.append(nums[i] + num)
                
            sum_set.update(curr_list)
            if target in sum_set:
                return True
        
        return False