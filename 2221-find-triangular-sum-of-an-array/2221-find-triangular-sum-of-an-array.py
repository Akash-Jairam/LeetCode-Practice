class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        copy = [n for n in nums]
        
        while len(copy) > 1:
            new = []
            for i in range(len(copy) - 1):
                new.append((copy[i] + copy[i+1]) % 10)
            copy = new
        
        return copy[-1]