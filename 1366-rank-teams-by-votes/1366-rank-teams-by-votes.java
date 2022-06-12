class Solution {
    public String rankTeams(String[] votes) {
        Node[] nodes = new Node[26];
        
        for(int i = 0; i < 26; ++i){
            nodes[i] = new Node((char) (i + 'A'));
        }
        
        for(String vote: votes){
            for(int i = 0; i < vote.length(); ++i){
                nodes[vote.charAt(i) - 'A'].count[i]++;
            }
        }
        
        Arrays.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2){
                for(int i = 0; i < 26; ++i){
                    if(node1.count[i] != node2.count[i]){
                        return node2.count[i] - node1.count[i];
                    }
                }
                return node1.ch - node2.ch;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < votes[0].length(); ++i){
           sb.append(nodes[i].ch); 
        }
        
        return sb.toString();
    }
}

class Node{
    char ch;
    int[] count;
    
    public Node (char ch){
        this.ch = ch;
        this.count = new int[26];
    } 
}