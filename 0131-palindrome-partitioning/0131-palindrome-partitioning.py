class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def backtrack(s, idx, curr_list, res):
            if idx == len(s):
                res.append(list(curr_list))
            
            curr = ""
            for i in range(idx, len(s)):
                curr += s[i]
                if curr == curr[::-1]:
                    curr_list.append(curr)
                    backtrack(s, i+1, curr_list, res)
                    curr_list.pop()
        
        result = []
        backtrack(s, 0, [], result)
        return result
                