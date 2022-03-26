class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1]))
               return false;
        }
               
        return uf.numberOfComponents == 1;
    }
}

public class UnionFind{
    int[] parents;
    int[] size;
    int numberOfComponents;
    
    public UnionFind(int n){
         parents = new int[n];
        size = new int[n];
        numberOfComponents = n;
        
        for(int i = 0; i < parents.length; ++i){
            parents[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int curr){
        int root = curr;
        
        while(root != parents[root]){
            root = parents[root];
        }
        
        // Path compression
        while(curr != root){
            int preParent = parents[curr];
            parents[curr] = root;
            curr = preParent;
        }
        
        return root;
    }
    
    public int findComponentSize(int curr){
        int parent = find(curr);
        return size[parent];
    }
    
    public boolean union(int node1, int node2){
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        
        if(node1Parent == node2Parent)
            return false;
        
        if(size[node1Parent] > size[node2Parent]){
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        --numberOfComponents;
        return true;
    }
}