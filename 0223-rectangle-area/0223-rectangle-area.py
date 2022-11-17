class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        firstArea = (ax2 - ax1) * (ay2 - ay1)
        secondArea = (bx2 - bx1) * (by2 - by1)
        width_overlap = self.findOverlap(ax1, ax2, bx1, bx2)
        height_overlap = self.findOverlap(ay1, ay2, by1, by2)
        return firstArea + secondArea - width_overlap * height_overlap
    
    def findOverlap(self,a, b, c, d):
        left = max(a, c)
        right = min(b, d)
        if right > left:
            return right - left
        
        return 0