class Solution:
    def isPalindrome(self, s: str) -> bool:
        start, end = 0, len(s) - 1
        
        while start < end:
            while start < end and not self.isAlphaNum(s[start]):
                start += 1
            
            while start < end and not self.isAlphaNum(s[end]):
                end -= 1
            
            
            if s[start].lower() != s[end].lower():
                return False
            
            start += 1
            end -= 1
        
        return True
    
    def isAlphaNum(self, c):
        c_val = ord(c)
        return (ord('A') <= c_val <= ord('Z') or
                ord('a') <= c_val <= ord('z') or
                ord('0') <= c_val <= ord('9'))