from collections import deque

class Solution:
    def reverseWords(self, s: str) -> str:
        words = deque()
        curr_word = []
        res = []
        for c in s:
            if c == ' ':
                if curr_word:
                    words.appendleft(''.join(curr_word))
                    curr_word = []
            else:
                curr_word.append(c)
        
        if curr_word:
            words.appendleft(''.join(curr_word))
            
        return ' '.join(words)
                
        
        
        
        