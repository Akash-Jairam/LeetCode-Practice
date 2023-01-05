class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
       
        i, curr, res = 1, points[0], 0
        
        while i < len(points):
            if points[i][0] <= curr[1]:
                curr[0], curr[1] = max(curr[0], points[i][0]), min(curr[1], points[i][1])
            else:
                res += 1
                curr = points[i]
            
            i += 1
        
        return res + 1
                
            
        