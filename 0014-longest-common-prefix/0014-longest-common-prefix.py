class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        min_length = sys.maxsize
        
        for s in strs:
            min_length = min(min_length, len(s))
        
        for i in range(min_length):
            for j in range(1, len(strs)):
                if strs[j][i] != strs[j-1][i]:
                    return res
            res += strs[0][i]
        
        return res