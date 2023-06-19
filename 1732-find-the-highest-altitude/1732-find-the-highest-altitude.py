class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        n, curr, highest = len(gain), 0, 0 
        
        for i in range(n):
            curr =  curr + gain[i]
            highest = max(highest, curr)
        
        return highest