class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        merged = []
        i, curr = 1, points[0]
        
        while i < len(points):
            if points[i][0] <= curr[1]:
                curr[0], curr[1] = max(curr[0], points[i][0]), min(curr[1], points[i][1])
            else:
                merged.append(curr)
                curr = points[i]
            
            i += 1
        
        return len(merged) + 1
                
            
        