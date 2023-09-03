class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        min_diff = float('inf')
        n_set = set(arr)
        for i in range(1, len(arr)):
            min_diff = min(min_diff, abs(arr[i] - arr[i-1]))

        res = []
        for i in range(len(arr)):
            if arr[i] - min_diff in n_set:
                res.append(sorted([arr[i], arr[i] - min_diff]))
        
        return sorted(res)