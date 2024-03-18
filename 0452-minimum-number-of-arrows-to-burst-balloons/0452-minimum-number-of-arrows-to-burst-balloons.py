class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        res = 0
        points.sort()
        curr = points[0]
        
        for i in range(1, len(points)):
            if curr[1] >= points[i][0]:
                curr = [max(curr[0], points[i][0]), min(curr[1], points[i][1])]
            else:
                res += 1
                curr = points[i]
        
        return res + 1