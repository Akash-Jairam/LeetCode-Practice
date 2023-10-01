class Solution:
    def reverseWords(self, s: str) -> str:
        split = s.split()
        for i in range(len(split)):
            split[i] = split[i][::-1]
            
        return ' '.join(split)