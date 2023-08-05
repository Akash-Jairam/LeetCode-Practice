from collections import deque
class WordDictionary:
    class Node:
        def __init__(self):
            self.children = {}
            self.word = None
            
    def __init__(self):
        self.root = self.Node()

    def addWord(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            curr.children[c] = curr.children.get(c, self.Node())
            curr = curr.children[c]
        
        curr.word = word

    def search(self, word: str) -> bool:
        q = deque()
        q.append(self.root)
        
        for c in word:
            while q:
                size = len(q)
                for _ in range(size):
                    curr = q.popleft()
                    if c == '.':
                        for child in curr.children.values():
                            q.append(child)
                    else:
                        curr = curr.children.get(c, None)
                        if curr:
                            q.append(curr)
                break
        
        for node in q:
            if node.word:
                return True
        
        return False


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)