class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        numsByBits = [[self.countBits(num), num] for num in arr]
        numsByBits.sort()
        return [l[1] for l in numsByBits]
        
    def countBits(self, num):
        bits = 0
        while num:
            num = num & num - 1
            bits += 1
        
        return bits