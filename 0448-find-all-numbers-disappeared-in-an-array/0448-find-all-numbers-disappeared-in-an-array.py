class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        sort_arr, res = [0] * (n + 1), []
        for i in range(n):
            sort_arr[nums[i]] += 1
        
        for i in range(1, n+1):
            if sort_arr[i] == 0:
                res.append(i)
        
        return res
        