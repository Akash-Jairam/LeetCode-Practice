from collections import defaultdict
class TrieNode:
    def __init__(self):
        self.children = {}
        self.sentences = defaultdict(int)
        
class AutocompleteSystem:

    def __init__(self, sentences: List[str], times: List[int]):
        self.root = TrieNode()
        for sentence, time in zip(sentences, times):
            self.add_to_trie(sentence, time)
        self.current_sentence = []
        self.curr_node = self.root
        self.dead = TrieNode()

    def input(self, c: str) -> List[str]:
        if c == '#':
            current_sentence = ''.join(self.current_sentence)
            self.add_to_trie(current_sentence, 1)
            self.current_sentence = []
            self.curr_node = self.root
            return []
       
        self.current_sentence.append(c)
        if c not in self.curr_node.children:
            self.curr_node = self.dead
            return []
        
        self.curr_node = self.curr_node.children[c]
        sorted_sentences = sorted(self.curr_node.sentences.items(), key = lambda x: (-x[1], x[0]))
        res = []
        for i in range(min(3, len(sorted_sentences))):
            res.append(sorted_sentences[i][0])
        return res
    def add_to_trie(self, sentence, count):
        it = self.root
        for c in sentence:
            if c not in it.children:
                it.children[c] = TrieNode()
            it = it.children[c]
            it.sentences[sentence] += count
        

# Your AutocompleteSystem object will be instantiated and called as such:
# obj = AutocompleteSystem(sentences, times)
# param_1 = obj.input(c)