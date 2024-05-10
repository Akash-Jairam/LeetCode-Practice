class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        fs = []
        
        for i in range(len(arr)- 1):
            num1 = arr[i]
            for j in range(len(arr)):
                num2 = arr[j]
                fs.append((arr[i]/arr[j], [num1, num2]))
        
        fs.sort()
        return fs[k-1][1]