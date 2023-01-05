class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        # Merge interval
        # But instead we only take the common interval
        # If we can't merge intervals, we increase our count
        # Else we merge
        # Return count plus the remaining interval to be merged
        points.sort()
       
        i, curr, res, n = 1, points[0], 0, len(points)
        
        while i < n:
            if points[i][0] <= curr[1]:
                curr[0], curr[1] = max(curr[0], points[i][0]), min(curr[1], points[i][1])
            else:
                res += 1
                curr = points[i]
            
            i += 1
        
        return res + 1
                
            
        