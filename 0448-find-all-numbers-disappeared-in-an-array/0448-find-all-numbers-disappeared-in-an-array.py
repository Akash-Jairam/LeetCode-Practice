class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # Count Sort 
        # Use array to note which elements are in nums
        # Iterate thru array from index 1 and add to res any indices which are set to 0
        n = len(nums)
        sort_arr, res = [0] * (n + 1), []
        for i in range(n):
            sort_arr[nums[i]] += 1
        
        for i in range(1, n+1):
            if sort_arr[i] == 0:
                res.append(i)
        
        return res
        