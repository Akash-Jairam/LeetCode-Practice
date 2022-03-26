class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        
        return uf.numComponents;
    }
}

class UnionFind{
    int[] parent;
    int[] size;
    int numComponents;
    
    public UnionFind (int n) {
        parent = new int[n];
        size = new int[n];
        numComponents = n;
        
        for(int i = 0; i < parent.length; ++i){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int node){
        int root = node;
        
        while(root != parent[root]){
            root = parent[root];
        }
        
        while(node != root){
            int previousParent = parent[node];
            parent[node] = root;
            node = previousParent;
        }
        
        return root;
    }
    
    public void union(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        
        if(parent1 == parent2)
            return;
        
        if(size[parent1] > size[parent2]){
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        } else{
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        }
        --numComponents;
    }
}