from collections import deque
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if len(arr) <= k:
            return arr
        
        closest = 0
        closestDiff = abs(x - arr[0])
        
        for i in range(1, len(arr)):
            diff = abs(x - arr[i])
            if diff < closestDiff:
                closestDiff = diff
                closest = i
        
        l = closest - 1
        r = closest
        res = deque()
        
        while len(res) < k:
            lVal = abs(arr[l] - x) if l >= 0 else float('inf')
            rVal = abs(arr[r] - x) if r < len(arr) else float('inf')
            
            if lVal < rVal or lVal == rVal:
                res.appendleft(arr[l])
                l -= 1
            elif rVal < lVal:
                res.append(arr[r])
                r += 1
            
        
        return res
            