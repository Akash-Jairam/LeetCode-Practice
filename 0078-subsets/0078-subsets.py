class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrack(0, nums, [], res)
        return res
    
    def backtrack(self, i, arr, curr, res):
        if i == len(arr):
            res.append(curr[::])
            return
        
        curr.append(arr[i])
        self.backtrack(i + 1, arr, curr, res)
        curr.pop()
        
        self.backtrack(i + 1, arr, curr, res)