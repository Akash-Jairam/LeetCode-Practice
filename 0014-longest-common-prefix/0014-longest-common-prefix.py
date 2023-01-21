class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = ""
        first = last = strs[0]
        
        for i in range(1, len(strs)):
            curr_s = strs[i]
            if curr_s < first:
                first = curr_s
            
            if curr_s > last:
                last = curr_s
        
        for i in range(min(len(first), len(last))):
            if first[i] != last[i]:
                return res
            res += first[i]
        
        return res
                
        
        