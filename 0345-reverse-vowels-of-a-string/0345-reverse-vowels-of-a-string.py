class Solution:
    def reverseVowels(self, s: str) -> str:
        s_chars = list(s)
        i, j = 0, len(s) - 1
        vowels = set('aAeEiIoOuU')
        while i < j :
            while i < j and s_chars[i] not in vowels:
                i += 1
            while i < j and s_chars[j] not in vowels:
                j -= 1
            
            if i > j:
                break
            
            s_chars[i], s_chars[j] = s_chars[j], s_chars[i]
            i += 1
            j -= 1
        
        return "".join(s_chars)
        