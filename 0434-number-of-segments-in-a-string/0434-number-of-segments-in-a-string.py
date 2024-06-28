class Solution:
    def countSegments(self, s: str) -> int:
        seg = 0 
        
        for i in range(len(s)):
            if(i == 0 or s[i-1] == ' ') and s[i] != ' ':
                seg += 1
        
        return seg