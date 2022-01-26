class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbor : adjacencyList.get(node)){
                if(map.get(node) == neighbor)
                    continue;
                
                if(map.containsKey(neighbor)){
                    return false;
                }
                
                map.put(neighbor, node);
                stack.push(neighbor);
            }
        }
        
        return map.size() == n;
    }
    
    
}