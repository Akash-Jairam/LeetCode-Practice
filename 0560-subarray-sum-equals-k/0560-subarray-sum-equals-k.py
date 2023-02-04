from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Use a hashmap to keep track of subarray sums
        # Set the value of key 0 to 1 to start out
        # Iterate through nums while adding individual elements to prefix sum
        # Check to see if there is an element in the map that is equal to the diff of prefix sum - k
        # If there is, that means that at least.1 subarray sum == k
        # Update result by the value of that diff
        # Increment the count of that prefix key by 1
        pre_map = defaultdict(int)
        pre_map[0] = 1
        res, prefix = 0, 0
        
        for num in nums:
            prefix += num
            if prefix - k in pre_map:
                res += pre_map[prefix - k]
            
            pre_map[prefix] += 1
        
        return res