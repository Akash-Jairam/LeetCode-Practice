class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        curr = words[0]
        kept = [1] * len(words)
        for i in range(1, len(words)):
            if self.isAnagram(curr, words[i]):
                kept[i] -= 1
            else:
                curr = words[i]
        
        return [words[i] for i in range(len(kept))  if kept[i]]
        
    
    def isAnagram(self, a, b):
        if len(a) != len(b):
            return False
        
        c_map = [0] * 26
        for i in range(len(a)):
            aI = ord(a[i]) - ord('a')
            bI = ord(b[i]) - ord('a')
            c_map[aI] += 1
            c_map[bI] -= 1
        
        for i in range(26):
            if c_map[i] != 0:
                return False
        
        return True