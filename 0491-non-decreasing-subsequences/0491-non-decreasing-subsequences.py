class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        def backtrack(arr, idx, curr_list, res_list):
            if len(curr_list) > 1:
                res_list.append(curr_list)
            
            used = set({})
            
            for i in range(idx, len(arr)):
                if (curr_list and curr_list[-1] > arr[i]):
                    continue
                
                if arr[i] in used:
                    continue
                used.add(arr[i])
                backtrack(arr, i + 1, curr_list + [arr[i]], res_list)
                
        res = []
        backtrack(nums, 0, [], res)
        return res