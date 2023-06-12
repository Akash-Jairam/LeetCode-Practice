class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        res = []     
        cur_idx = 0 
        
        while cur_idx < len(nums): 
            start = cur_idx  
            while cur_idx < len(nums) - 1 and nums[cur_idx] + 1 == nums[cur_idx + 1]: 
                cur_idx += 1 
            
            if cur_idx != start: 
                res.append(str(nums[start]) + "->" + str(nums[cur_idx]))
            else: 
                res.append(str(nums[cur_idx]))
            
            cur_idx += 1
        return res 