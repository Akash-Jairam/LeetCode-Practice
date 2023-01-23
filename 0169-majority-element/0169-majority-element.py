from collections import Counter
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = Counter(nums)
        threshold = len(nums) // 2
        for key, value in count.items():
            if value > threshold:
                return key
        
        return -1
            
        