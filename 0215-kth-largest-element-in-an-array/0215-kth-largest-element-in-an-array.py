class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        n = len(nums)
        kth = n - k
        
        def quickSelect(l, r):
            pivot, p =  nums[r], l
            
            for i in range(l, r):
                if nums[i] <= pivot:
                    nums[i], nums[p] = nums[p], nums[i]
                    p += 1
                
            nums[p], nums[r] = nums[r], nums[p]
            
            if p > kth:
                return quickSelect(l, p - 1)
            elif p < kth:
                return quickSelect(p + 1, r)
            else:
                return nums[p]
        
        
        return quickSelect(0, n-1)