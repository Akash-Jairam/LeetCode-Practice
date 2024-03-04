class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        score = 0
        tokens.sort()
        left, right = 0, len(tokens) - 1
        while left <= right:            
            if tokens[left] <= power:
                power -= tokens[left]
                score += 1
                left += 1
            elif score and left < right:
                power += tokens[right]
                score -= 1
                right -= 1
            else:
                return score
        return score