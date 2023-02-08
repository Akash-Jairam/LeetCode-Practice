class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            x = nums[i]
            start, end = i + 1, n - 1
            while start < end:
                total =  x + nums[start] + nums[end] 
                if total > 0:
                    end -= 1
                elif total < 0:
                    start += 1
                else:
                    res.append([x, nums[start], nums[end]])
                    while start < end and nums[start] == nums[start+1]:
                        start += 1
                    
                    while start < end and nums[end] == nums[end-1]:
                        end -= 1
                    start += 1
                    end -= 1
        return res