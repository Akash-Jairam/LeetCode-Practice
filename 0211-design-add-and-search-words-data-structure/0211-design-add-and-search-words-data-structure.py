class WordDictionary:
    
    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = None
            
    def __init__(self):
        self.root = self.Node()

    def addWord(self, word: str) -> None:
        it = self.root
        
        for c in word:
            idx = ord(c) - ord('a')
            
            if not it.children[idx]:
                it.children[idx] = self.Node()
            
            it = it.children[idx]
            
        it.word = word
        
    def helper(self, it, word, j):
        for i in range(j, len(word)):
            if word[i] == '.':
                res = False
                for child in it.children:
                    if child and self.helper(child, word, i+1):
                        return True
                return False
            else:
                idx = ord(word[i]) - ord('a')
                if not it.children[idx]:
                    return False
                it = it.children[idx]
        
        return it.word != None
    
    def search(self, word: str) -> bool:
        return self.helper(self.root, word, 0)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)