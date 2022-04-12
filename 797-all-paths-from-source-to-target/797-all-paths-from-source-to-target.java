class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> adjacencyMatrix = new HashMap<>();
        
        for(int i = 0; i < graph.length; ++i){
            adjacencyMatrix.put(i, new HashSet());
            for(int num : graph[i])
                adjacencyMatrix.get(i).add(num);
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0));
        int destination = graph.length-1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < queue.size(); ++i){
                List<Integer> curr = queue.poll();
                Integer path = curr.get(curr.size()-1);
                if(path == destination){
                    res.add(curr);
                    continue;
                }
                for(int num : adjacencyMatrix.get(path)){
                    List<Integer> list = new ArrayList<>(curr);
                    list.add(num);
                    queue.offer(list);
                    
                }
            }
        }
        
        for(int i = 0; i < res.size(); ++i){
            if(!res.get(i).contains(graph.length -1))
                res.remove(i);
        }
        
        return res;
    }
}