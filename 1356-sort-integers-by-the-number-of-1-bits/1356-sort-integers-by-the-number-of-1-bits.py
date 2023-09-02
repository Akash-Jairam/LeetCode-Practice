class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        numsByBits = sorted([(self.countBits(num), num) for num in arr])
        return [p[1] for p in numsByBits]
        
    
    def countBits(self, num):
        numBits = 0
        
        while num:
            num = num & num - 1
            numBits += 1
        
        return numBits