class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        def binarySearch(m, target):
            left, right = 0, len(m) - 1
            
            while left <= right:
                mid = left + int((right - left) / 2)
                if m[mid] < target:
                    left = mid + 1
                elif m[mid] > target:
                    right = mid - 1
                else:
                    right = mid
                    break
            
            return m[right] == target
        
        
        for m in matrix:
            if m[0] <= target <= m[-1]:
                return binarySearch(m, target)
        
        return False