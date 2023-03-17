class Trie:
    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = False
    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        it = self.root
        
        for c in word:
            idx = ord(c) - ord('a')
            if not it.children[idx]:
                it.children[idx] = self.Node()
            
            it = it.children[idx]
        it.word = True

    def search(self, word: str) -> bool:
        curr = self.traverse(word)
        
        return curr and curr.word

    def startsWith(self, prefix: str) -> bool:
        curr = self.traverse(prefix)
        if not curr:
            return False
        
        return True if curr else False
    
    def traverse(self, word):
        it = self.root
        
        for c in word:
            idx = ord(c) - ord('a')
            if not it.children[idx]:
                return None
            it = it.children[idx]
        
        return it


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)