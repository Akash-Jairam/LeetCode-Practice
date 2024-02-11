class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # Keep a map of characters in t and their frequency
        # Keep track of how many characters you have and how many you need
        # Create a map to keep track of characters in s and their frequency
        # Create a result array and a result length to track the indicies of the result and the minimum res length
        # Iterate through s making sure to update the corresponding map and have count
        # While have == need, we check to see if we need to update res and resLength,then we slide to the right making sure to decrement have if needed
        # Finally, we return the substring if the resLength is not infinity, otherwise, we return ""
        
        t_map = {}
        for c in t:
            t_map[c] = 1 + t_map.get(c, 0)
            
        s_map = {}
        res, resLen = [-1, -1], float('inf')
        have, need = 0, len(t)
        l = 0
        
        for r in range(len(s)):
            c = s[r]
            s_map[c] = 1 + s_map.get(c, 0)
            
            if c in t_map and s_map[c] <= t_map[c]:
                have += 1
            
            while have == need:
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res = [l, r]
                
                c = s[l]
                s_map[c] -= 1
                if c in t_map and s_map[c] < t_map[c]:
                    have -= 1
                
                l += 1
        
        l, r = res
        return s[l:r+1] if resLen != float('inf') else ""