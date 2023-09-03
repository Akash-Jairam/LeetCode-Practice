class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        curr = self.mapToTup(words[0])
        prev = 0
        kept = [1] * len(words)
        for i in range(1, len(words)):
            nxt = self.mapToTup(words[i])
            if curr == nxt:
                kept[i] -= 1
            else:
                curr = nxt
        
        return [words[i] for i in range(len(kept))  if kept[i]]
        
    
    def mapToTup(self, s):
        arr = [0] * 26
        
        for c in s:
            i = ord(c) - ord('a')
            arr[i] += 1
        
        return tuple(arr)
    