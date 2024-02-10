class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        l, r = 0, len(nums) - 1
        idx = 0
        while l <= r:
            mid = l + (r - l) // 2
            
            if nums[mid] >= target:
                r = mid - 1
                idx = mid
            else:
                l = mid  + 1
        
        return idx + len(nums) // 2 < len(nums) and nums[idx + len(nums) //2] == target