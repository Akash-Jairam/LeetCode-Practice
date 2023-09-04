class Solution:
    def minFlips(self, target: str) -> int:
        status = '0'
        flips = 0
        for c in target:
            if c != status:
                status = '0' if status == '1' else '1'
                flips += 1
        
        return flips