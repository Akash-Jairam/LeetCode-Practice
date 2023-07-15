class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        tup_arr = [(f'{num:b}', num) for num in arr]
        tup_arr = [(self.count1s(p[0]), p[1]) for p in tup_arr]
        tup_arr.sort()
        return [p[1] for p in tup_arr]
    
    
    def count1s(self, num):
        count = 0
        for c in num:
            if c == '1':
                count += 1
        
        return count
    
    