class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        scores = [(score[i], i) for i in range(len(score))]
        scores.sort()
        res = [""] * len(scores)
        
        start = 0
        for i in range(len(score) -1 , -1 , -1):
            idx = scores[i][1]
            if i == len(score) - 1:
                res[idx] =  "Gold Medal"
            elif i == len(score) - 2:
                res[idx] = "Silver Medal"
            elif i == len(score) - 3:
                res[idx] = "Bronze Medal"
            else:
                res[idx] = str((start+1))
            start += 1

        return res
        
        