class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        
        num_caps = 0
        for c in word:
            if c.isupper():
                num_caps += 1
        
        return (word[0].isupper() and num_caps == 1) or num_caps == len(word) or num_caps == 0
        