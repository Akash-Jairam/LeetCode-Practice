class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, c_set = 0, set()
        res = 0
        for c in s:
            while c in c_set:
                c_set.remove(s[l])
                l += 1
            
            c_set.add(c)
            res = max(res, len(c_set))
        
        return res