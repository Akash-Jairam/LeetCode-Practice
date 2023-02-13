class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binarySearch(arr, left, right, target):
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] > target:
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    return mid
            
            return -1
        
        minimum = nums[0]
        minIdx = 0
        l, r = 0, len(nums) - 1
        
        while l <= r:
            if nums[l] < nums[r]:
                if nums[l] < minimum:
                    minimum = nums[l]
                    minIdx = l
                break
            
            
            mid = l + (r - l) // 2
            if nums[mid] < minimum:
                    minimum = nums[mid]
                    minIdx = mid
            if nums[mid] >= nums[l]:
                l = mid + 1
            else:
                r = mid - 1
        
        idx = binarySearch(nums, minIdx, len(nums) - 1, target)
        
        return idx if idx != -1 else binarySearch(nums, 0, minIdx - 1, target)
