class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        kth = len(nums) - k
        
        def quickSelect(l, r):
            pivot, p = nums[r], l
            
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[i], nums[p] = nums[p], nums[i]
                    p += 1
                
            nums[p], nums[r] = nums[r], nums[p]
            
            return p
        
        left, right = 0, len(nums) - 1
        
        while left < right:
            partition = quickSelect(left, right)
            
            if partition < kth:
                left = partition + 1
            elif partition > kth:
                right = partition - 1
            else:
                break
        
        return nums[kth]
            