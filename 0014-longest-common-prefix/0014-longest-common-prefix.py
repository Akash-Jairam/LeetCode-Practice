class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix_map = {}
        res = ""
        for s in strs:
            curr_s = []
            for c in s:
                curr_s.append(c)
                curr_word = "".join(curr_s)
                if curr_word in prefix_map:
                    prefix_map[curr_word] += 1
                else:
                    prefix_map[curr_word] = 1
        
        for key in prefix_map.keys():
            if prefix_map[key] == len(strs) and len(key) > len(res):
                res = key
        
        return res
        