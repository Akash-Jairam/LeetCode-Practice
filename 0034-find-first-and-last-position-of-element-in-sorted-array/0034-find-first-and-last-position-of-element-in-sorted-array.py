class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1 ]
        if not nums or len(nums) == 0:
            return res
        
        res[0] = self.findFirstTarget(nums, target)
        res[1] = self.findLastTarget(nums, target)
        return res
      
    def findFirstTarget(self, nums, target):
        l, r = 0, len(nums) - 1
        
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] < target:
                l = mid + 1
            else:
                r = mid
        
        return l if nums[r] == target else -1
    
    def findLastTarget(self, nums, target):
        l, r = 0, len(nums) - 1
        
        while l < r:
            mid = (l + (r - l) // 2) + 1
            if nums[mid] > target:
                r = mid - 1
            else:
                l = mid
        
        return r if nums[r] == target else -1
                    