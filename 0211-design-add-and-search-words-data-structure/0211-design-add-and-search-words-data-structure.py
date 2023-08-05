from collections import deque
class WordDictionary:
    '''
        Use a Trie
        Create a class Node which has a map and a word as it's properties. Map is set to a map and word is set to None
        
        init:
        Set the root property to a new Node
        
        insert:
        Set the iterator to the root
        Iterate through the word
        Check to see if the iterator has a child at the curr char, if not insert a new Node
        Keep going until we exit the word
        Set the iterator's word propert to the given word at the end
        
        search:
        Create a queue and append the root to it
        Iterate through the word
        While the queue is not empty:
            Create an inner loop that runs according to the size of the inner loop:
                Check to see if the curr character is not equal to '.'
                If true, pop nodes from the queue and check to see if each node has a child at c. If any do, append them to the queue
                If false, append all children from the curr node to the queue
            Break the while loop after the inner loop finishes executing so we can move to the next character
        
        After all the loops are finished executing, check each node that is still in the queue and see if any has a word property that is not None. If true, return true 
        Return False if there are no Nodes in the queue that have an actual word assigned
            
            After we finish one iteration 
    '''
    class Node:
        def __init__(self):
            self.children = {}
            self.word = None
            
    def __init__(self):
        self.root = self.Node()

    def addWord(self, word: str) -> None:
        # TC: O(M)
        # SC: O(M)
        curr = self.root
        
        for c in word:
            curr.children[c] = curr.children.get(c, self.Node())
            curr = curr.children[c]
        
        curr.word = word

    def search(self, word: str) -> bool:
        # TC: O(N * 26 ^ M)
        # SC: O(M)
        return self.dfs(0, word, self.root)

    
    def dfs(self, i, word, node):
        for j in range(i, len(word)):
            if word[j] == '.':
                for child in node.children.values():
                    if self.dfs(j + 1, word, child):
                        return True
                return False
            else:
                node = node.children.get(word[j], None)
                if not node:
                    return False
                
        
        return node and node.word != None

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)