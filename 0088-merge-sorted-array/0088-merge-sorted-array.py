class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        k = len(nums1) - 1
        lastIndexOfNums1 = m - 1
        lastIndexOfNums2 = n - 1
        
        while k >= 0:
            n1 = nums1[lastIndexOfNums1] if lastIndexOfNums1 >= 0 else float('-inf')
            n2 = nums2[lastIndexOfNums2] if lastIndexOfNums2 >= 0 else float('-inf')
            if n1 > n2:
                nums1[k] = n1
                lastIndexOfNums1 -= 1
            else:
                nums1[k] = n2
                lastIndexOfNums2 -= 1
            k -= 1