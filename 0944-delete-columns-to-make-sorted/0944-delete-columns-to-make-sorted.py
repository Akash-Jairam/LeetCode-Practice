class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        res, s_length, i = 0, len(strs[0]), 0
        
        while i < s_length:
            for j in range(1, len(strs)):
                if strs[j][i] < strs[j-1][i]:
                    res += 1
                    break
            i += 1
        
        return res
        