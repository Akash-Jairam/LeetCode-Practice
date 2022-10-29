class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        prev_nums = set()
        for n in nums:
            if n in prev_nums:
                return True
            prev_nums.add(n)
            
        return False
        