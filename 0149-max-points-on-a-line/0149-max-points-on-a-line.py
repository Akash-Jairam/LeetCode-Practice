class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        def helper(currPt, points):
            x1, y1 = currPt
            grad_map, ans, duplicates = {}, 0, 0
            
            for x2, y2 in points:
                if x1 == x2 and y1 == y2:
                    duplicates += 1
                else:
                    grad = (y2 - y1) / (x2 - x1) if x2 - x1 != 0 else float('inf')
                    count = 1 + grad_map.get(grad, 0)
                    grad_map[grad] = count
                    ans = max(ans, count)
            
            return ans + 1 + duplicates
        res = 0
        while points:
            currPt = points.pop()
            res = max(res, helper(currPt, points))
        
        return res