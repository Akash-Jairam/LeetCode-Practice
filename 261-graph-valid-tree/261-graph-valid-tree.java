class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Create and initialize adjacency matrix
        // Loop through edges and add them to the adjacency matrix
        
        // Initialize a stack and a map
        // Loop through the stack and compare the item to the adjacency matrix
        // Push the neighbor to the stack and add the relationship to the adjacency matrix
        List<List<Integer>> adjacencyMatrix = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            adjacencyMatrix.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adjacencyMatrix.get(edge[0]).add(edge[1]);
            adjacencyMatrix.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,  Integer> map = new HashMap<Integer, Integer>();
        stack.push(0);
        map.put(0,-1);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbor : adjacencyMatrix.get(node)){
                if(neighbor == map.get(node))
                    continue;
                if(map.containsKey(neighbor))
                    return false;
                stack.push(neighbor);
                map.put(neighbor, node);
            }
        }
        
        return map.size() == n;
    }
}