class WordDictionary {
    Node root;
    public WordDictionary() {
       root = new Node(); 
    }
    
    public void addWord(String word) {
        Node curr = root;
        
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node();
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        char[] c = word.toCharArray();
        return helper(root, 0, c);
    }
    
    public boolean helper(Node curr, int pos, char[] word){
        if(pos == word.length)
            return curr.isWord;
        for(int i = pos; i < word.length; ++i){
            if(word[i] == '.'){
                for(int j = 0; j < curr.children.length; ++j){
                    if(curr.children[j] != null && helper(curr.children[j], pos+1, word))
                        return true;
                }
            } else {
                return curr.children[word[i] - 'a'] != null && helper(curr.children[word[i] - 'a'], pos+1, word);
            }
        }
        
        return false;
    }
}

class Node {
    Node[] children;
    boolean isWord;
    public Node(){
        this.children = new Node[26];
        this.isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */