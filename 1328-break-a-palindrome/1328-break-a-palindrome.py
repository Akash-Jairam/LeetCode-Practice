class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        if len(palindrome) == 1:
            return ""
        
        c_arr = list(palindrome)
        i = 0
        
        while i < len(palindrome) // 2 and c_arr[i] == 'a':
            i += 1
        
        if i < len(palindrome) // 2:
            c_arr[i] = 'a'
        else:
            c_arr[-1] = 'b'
        
        return ''.join(c_arr)