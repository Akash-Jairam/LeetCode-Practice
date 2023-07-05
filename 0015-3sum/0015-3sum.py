class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        n = len(nums)
        
        for i in range(n - 2):
            n1 = nums[i]
            start = i + 1
            end = n - 1
            
            if i > 0 and nums[i] == nums[i-1]:
                continue
            while start < end:
                total = n1 + nums[start] + nums[end]
                if total > 0:
                    end -= 1
                elif total < 0:
                    start += 1
                else:
                    res.append([n1, nums[start], nums[end]])
                    while start < end and nums[start] == nums[start+1]:
                        start += 1
                    while end > start and nums[end] == nums[end - 1]:
                        end -= 1
                        
                    start += 1
                    end -= 1
        
        return res
                    