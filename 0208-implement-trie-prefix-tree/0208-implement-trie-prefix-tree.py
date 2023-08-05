class Trie:
    class Node:
        def __init__(self):
            self.children = {}
            self.word = None
        
    def __init__(self):
        self.root = self.Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for c in word:
            curr.children[c] = curr.children.get(c, self.Node())
            curr = curr.children[c]
        
        curr.word =  word

    def search(self, word: str) -> bool:
        result = self.traverse(word)
        
        return (result and result.word != None)

    def startsWith(self, prefix: str) -> bool:
        result = self.traverse(prefix)
        return result and len(result.children.keys()) >= 0
    
    def traverse(self, s):
        curr = self.root
        for c in s:
            curr = curr.children.get(c, None)
            if not curr:
                return None
        
        return curr
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)