class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(arr, curr, res, idx):
            if idx == len(arr):
                res.append(curr.copy())
                return
            
            curr.append(arr[idx])            
            backtrack(arr, curr, res, idx+1)
            
            curr.pop()
            backtrack(arr, curr, res, idx+1)
        
        res = []
        backtrack(nums, [], res, 0)
        return res