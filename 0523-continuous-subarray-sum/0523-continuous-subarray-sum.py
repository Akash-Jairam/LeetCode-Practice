class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        # Use a map to keep track of remainders and the index where they were found
        # Also use a variable to track the running sum
        # If you found a remainder that is already in the map and there is at least a two index gap between the map's idx and the curr idx, return true
        # This is because a multiple of k was found between the gap
        # Return false at the end of the func
        remainder = {0: -1}
        total = 0
        
        for i in range(len(nums)):
            total += nums[i]
            r = total % k
            
            if r not in remainder:
                remainder[r] = i
            elif i - remainder[r] > 1:
                return True
        
        
        return False