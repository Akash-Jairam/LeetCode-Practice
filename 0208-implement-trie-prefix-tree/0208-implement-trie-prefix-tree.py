class Trie:
    
    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = None
            
    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        it = self.root
        
        for c in word:
            idx = ord(c) - ord('a')
            if not it.children[idx]:
                it.children[idx] = self.Node()
            
            it = it.children[idx]
        it.word = word

    def search(self, word: str) -> bool:
        it = self.root
        
        for c in word:
            idx = ord(c) - ord('a')
            if not it.children[idx]:
                return False
            
            it = it.children[idx]
        
        return it.word == word

    def startsWith(self, prefix: str) -> bool:
        it = self.root

        for c in prefix:
            idx = ord(c) - ord('a')
            if not it.children[idx]:
                return False
            
            it = it.children[idx]
        
        return True if it else False

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)