class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        '''
            Classic tortoise and hare algorithm
            Have two pointers traverse the array but one moves twice as fast until they both meet again
            Set a new pointer at the beginning and have the new pointer and an old pointer both move at regular speed until they converge
            The point of convergence is the duplicate
        '''
        slow = fast = 0
        
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        
        slow2 = 0
        while True:
            slow = nums[slow]
            slow2 = nums[slow2]
            if slow == slow2:
                return slow
        