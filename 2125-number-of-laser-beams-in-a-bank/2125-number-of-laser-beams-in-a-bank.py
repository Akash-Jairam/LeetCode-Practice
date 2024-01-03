class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        prev = 0
        res = 0
        for row in bank:
            currBeams = 0
            for c in row:
                if c == '1':
                    currBeams += 1
            res = res + currBeams * prev
            if currBeams > 0:
                prev = currBeams
        
        return res