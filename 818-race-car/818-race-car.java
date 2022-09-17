class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        int level = 0;
        HashSet<List<Integer>> visited = new HashSet<>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; ++i){
                int[] curr = queue.poll();
                
                if(curr[0] == target){
                    return level;
                }
                
                int pos = curr[0] + curr[1];
                int speed = curr[1] * 2;
                List<Integer> next = List.of(pos, speed);
                
                if(!visited.contains(next) && Math.abs(pos - target) < target){
                    queue.offer(new int[]{pos, speed});
                    visited.add(next);
                }
                
                pos = curr[0];
                if(curr[1] > 0) speed = -1;
                else speed = 1;
                next = List.of(pos, speed);
                if(!visited.contains(next) && Math.abs(pos - target) < target){
                    queue.offer(new int[]{pos, speed});
                    visited.add(next);
                }
            }
            ++level;
        }
        
        return level;
    }
}