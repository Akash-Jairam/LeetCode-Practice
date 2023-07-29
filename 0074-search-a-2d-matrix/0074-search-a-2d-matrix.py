class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top, bottom = 0, len(matrix) - 1
        
        while top <= bottom:
            mid = top + (bottom - top) // 2
            
            if target  > matrix[mid][-1]:
                top = mid + 1
            elif target < matrix[mid][0]:
                bottom = mid - 1
            else:
                break
            
        
        if not top <= bottom:
            return False
        
        row = (top + bottom) // 2
        l, r = 0, len(matrix[row]) - 1
        
        while l <= r:
            m = l + (r - l) // 2
            
            if target > matrix[row][m]:
                l = m + 1
            elif target < matrix[row][m]:
                r = m - 1
            else:
                return True
        
        return False