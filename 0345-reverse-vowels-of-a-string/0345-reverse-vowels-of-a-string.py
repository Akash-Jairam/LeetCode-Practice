class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
        s_vowels = []
        res = []
        for c in s:
            if c in vowels:
                s_vowels.append(c)
        
        for c in s:
            if c not in vowels:
                res.append(c)
            else:
                res.append(s_vowels.pop())
        
        return "".join(res)
            