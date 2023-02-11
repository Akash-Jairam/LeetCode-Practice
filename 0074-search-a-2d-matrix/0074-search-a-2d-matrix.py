class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top, bot = 0, len(matrix) - 1
        
        while top <= bot:
            mid = top + ((bot - top) // 2)
            
            if matrix[mid][0] > target:
                bot = mid - 1
            elif matrix[mid][-1] < target:
                top = mid + 1
            else:
                break
        
        if not top <= bot:
            return False
            
        row = (top + bot) // 2
        left, right = 0, len(matrix[row]) - 1
        
        while left <= right:
            mid = left + ((right - left) // 2)
            val = matrix[row][mid]
            if val > target:
                right = mid - 1
            elif val < target:
                left = mid + 1
            else:
                return True
        
        return False