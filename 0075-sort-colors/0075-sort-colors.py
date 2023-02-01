class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def increment(val, arr, start):
            while start < len(arr) and arr[start] == val:
                start += 1
        
            return start
        
        def iterate_and_swap(arr, start, val):
            for i in range(start, len(arr)):
                if arr[i] == val:
                    arr[i], arr[start] = arr[start], arr[i]
                    start += 1
            return start
                    
        
        idx = increment(0, nums, 0)
        idx = iterate_and_swap(nums, idx, 0)
        idx = iterate_and_swap(nums, idx, 1)
        iterate_and_swap(nums, idx, 2)
     