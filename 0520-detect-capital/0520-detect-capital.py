class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        capitals = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        num_caps = 0
        for c in word:
            if str(c) in capitals:
                num_caps += 1
        
        return (word[0] in capitals and num_caps == 1) or num_caps == len(word) or num_caps == 0
        