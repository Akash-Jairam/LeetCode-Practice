class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        swap_idx = 0
        
        for i in range(len(nums)):
            if nums[i] != val:
                nums[swap_idx], nums[i] = nums[i], nums[swap_idx]
                swap_idx += 1
        
        return swap_idx
        