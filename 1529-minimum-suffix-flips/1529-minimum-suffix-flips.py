class Solution:
    def minFlips(self, target: str) -> int:
        curr = '0'
        flips = 0
        for c in target:
            if c != curr:
                flips += 1
                curr = '0' if curr == '1' else '1'
        
        return flips