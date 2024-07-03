class Solution:
    def validWordSquare(self, words: List[str]) -> bool:
        for i in range(len(words)):
            if not self.validate(words, i):
                return False
        
        return True
    
    def validate(self, w, idx):

        for j in range(len(w[idx])):
            if j >= len(w) or idx >= len(w[j]) or  w[idx][j] != w[j][idx]:
                return False
        
        return True