class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        prev = [1]
        
        for i in range(2, rowIndex + 2):
            curr = []
            for j in range(i):
                left = 0 if j - 1 < 0 else prev[j-1]
                right = 0 if j + 1 > len(prev) else prev[j]
                curr.append(left + right)
            
            prev = curr
        
        return prev