class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        root = Trie()
        products.sort()
        for p in products:
            it = root
            for c in p:
                idx = ord(c) - ord('a')
                it.children[c] = it.children.get(c, Trie())
                it.words.append(p)
                it = it.children[c]
            it.words.append(p)
        res = []
        it = root
        for c in searchWord:
            if c not in it.children:
                res.append([])
                it.children[c] = Trie()
            else:
                res.append(it.children[c].words[:3])
            it = it.children[c]
        
        return res
class Trie:
    def __init__(self):
        self.children = {}
        self.words = []