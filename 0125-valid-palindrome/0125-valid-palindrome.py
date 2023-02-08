class Solution:
    def isPalindrome(self, s: str) -> bool:
        c_list = [c for c in s.lower() if c.isalnum()] 
        new_s = ''.join(c_list)
        return new_s == new_s[::-1]