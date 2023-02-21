class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = 0, n- 1
        
        while l <= r:
            mid = l + (r-l) // 2
            lo = mid - 1
            hi = mid 
            if mid < n - 1 and nums[mid+1] == nums[mid]:
                lo = mid
                hi = mid + 1
            
            if lo % 2 == 0:
                l = mid + 1
            else:
                r = mid - 1
        
        return nums[l]