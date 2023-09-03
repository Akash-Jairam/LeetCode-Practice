from collections import defaultdict
class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        remainders = defaultdict(int)
        numPairs = 0
        for t in time:
            if t % 60 == 0:
                numPairs += remainders[0]
            else:
                numPairs += remainders[60 - t % 60]
            remainders[t % 60] += 1
        
        return numPairs