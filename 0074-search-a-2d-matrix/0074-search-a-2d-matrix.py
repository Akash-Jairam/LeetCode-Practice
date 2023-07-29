class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # Do a binary search on the rows to find a row that might have the target
        # Do a binary search on the numbers in that specific row to see if the target is there and return True or False based on your search
        m, n = len(matrix) - 1, len(matrix[0]) - 1
        top, bot = 0, m
        
        while top <= bot:
            mid = top + (bot - top) // 2
            
            if target < matrix[mid][0]:
                bot = mid - 1
            elif target > matrix[mid][-1]:
                top = mid + 1
            else:
                break
        
        if not top <= bot:
            return False
        
        row = top + (bot - top) // 2
        l, r = 0, n
        
        while l <= r:
            mid = l + (r - l) // 2
            
            if target < matrix[row][mid]:
                r = mid - 1
            elif target > matrix[row][mid]:
                l = mid + 1
            else:
                return True
        
        return False