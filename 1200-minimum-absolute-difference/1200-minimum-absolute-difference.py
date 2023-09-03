class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        res = []
        min_diff = float('inf')
        
        for i in range(1, len(arr)):
            diff = abs(arr[i] - arr[i-1])
            if diff < min_diff:
                res = [[arr[i-1], arr[i]]]
                min_diff = diff
            elif diff == min_diff:
                res.append([arr[i-1], arr[i]])
        
        return res