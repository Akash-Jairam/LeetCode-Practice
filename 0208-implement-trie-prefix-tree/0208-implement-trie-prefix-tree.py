class Trie:
    '''
        Create a class Node that has an empty map of children and a variable word which is initially set to None
        
        Initialize:
            Create a root variable and set it to Node()
        
        Insert method:
            Set an iterator at the root
            Go through the string and check to see if the iterator already has a child Node for that char else create one
            Then update the iterator to the child Node
            Keep doing this until we finish the word
            Finally, set the word property at the current iterator to the given word
        
        Search method:
            The search and startsWith methods have common functionality which will be extracted to a method called traverse
            Make a call to the traverse method to get the resulting Node value
            Return whether the Node value is not null and its word property is also not null
            
        StartsWith method:
            The search and startsWith methods have common functionality which will be extracted to a method called traverse
            Make a call to the traverse method to get the resulting Node value
            Return whether the Node value is not null and it has more than 0 keys
            
        traverse method:
            Set an iterator to the root 
            Iterate through the given string
            If there is a child for the given character, update the iterator else set the iterator to None
            If the iterator is None, return None
            When the loop is finished executing, return the Iterator
    '''
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