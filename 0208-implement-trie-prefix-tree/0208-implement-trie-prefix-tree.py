class Trie:

    class Node:
        def __init__(self):
            self.children = {}
            self.word = None
        
    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        it = self.root
        
        for c in word:
            it.children[c] = it.children.get(c, self.Node())
            it = it.children[c]
        
        it.word = word
        

    def search(self, word: str) -> bool:
        it = self.root
        
        for c in word:
            it = it.children.get(c, None)
            if not it:
                return False
        
        return it.word == word

    def startsWith(self, prefix: str) -> bool:
        it = self.root
        
        for c in prefix:
            it = it.children.get(c, None)
            if not it:
                return False
        
        return len(it.children) > 0 or it.word != None


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)