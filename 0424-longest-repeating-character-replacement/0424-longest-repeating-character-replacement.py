class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # Use a character map to keep track of the frequencies of the characters
        # Update the max frequency whenever a character is counted
        # Determine whether we need to replace more than k characters using the formula: r - l + 1 - max_f
        # Slide whenever we are violating this condition
        # Update the res by comparing it against the window at each iteration
        max_f, res = 0, 0
        c_map = {}
        l = 0
        for r in range(len(s)):
            c_map[s[r]] = 1 + c_map.get(s[r], 0)
            max_f = max(max_f, c_map[s[r]])
            
            while r - l + 1 - max_f > k:
                c_map[s[l]] -= 1
                l += 1
            
            res = max(res, r - l + 1)
        
        return res