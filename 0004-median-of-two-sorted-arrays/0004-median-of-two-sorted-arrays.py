class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m, n = len(nums1), len(nums2)
        if n < m:
            return self.findMedianSortedArrays(nums2, nums1)
        
        l, r = 0, m - 1
        total = (m + n) 
        half = total // 2
        
        while True:
            i = l + (r - l) // 2
            j = half - i - 2
            
            aLeft = nums1[i] if i >= 0 else float('-inf')
            aRight = nums1[i+1] if i + 1 < m else float('inf')
            bLeft = nums2[j] if j >= 0 else float('-inf')
            bRight = nums2[j+1] if j + 1< n else float('inf')
            
            if aLeft <= bRight and bLeft <= aRight:
                if total % 2:
                    return min(aRight, bRight)
                else:
                    return (max(aLeft, bLeft) + min(aRight, bRight)) / 2
            elif aLeft > bRight:
                r = i - 1
            else:
                l = i + 1
        
        return -1
                