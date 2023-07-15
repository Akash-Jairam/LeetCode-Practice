class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        tup_arr = [(self.count1s(num), num) for num in arr]
        tup_arr.sort()
        return [p[1] for p in tup_arr]
    
    
    def count1s(self, num):
        count = 0
        while num:
            num = num & num - 1
            count += 1
        return count
    
    