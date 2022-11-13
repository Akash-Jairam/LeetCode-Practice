from collections import deque

class Solution:
    def reverseWords(self, s: str) -> str:
        words = []
        curr_word = []
        res = []
        for c in s:
            if c == ' ':
                if curr_word:
                    words.append(''.join(curr_word))
                    curr_word = []
            else:
                curr_word.append(c)
        
        if curr_word:
            words.append(''.join(curr_word))
            
        for i in range(len(words) - 1, -1, -1):
            res.append(words[i])

        
        word = ' '.join(res)
        return word
                
        
        
        
        