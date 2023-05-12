"""
* loop through the questions from right to left
* matain a max_score during the loop and return it as the result
*
* @dp: an int dictionary, with index as key, the value is the max_score we can get start from that index
"""

class Solution:
    def mostPoints(self, questions: List[List[int]]) -> int:
        dp = defaultdict(int)
        max_score = 0
        i = len(questions) - 1
        while i >= 0:
            point, brainpower = questions[i]
            dp[i] = max(max_score, point + dp[i+brainpower+1])
            max_score = max(max_score, dp[i])
            i -= 1
        return max_score