class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n+1];
        int res = 0;
        for(int[] relation : relations){
            map.putIfAbsent(relation[0], new ArrayList<>());
            map.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }
        
        Queue<Integer> zeroDegree = new LinkedList<>();
        
        for(int i = 1; i < indegree.length; ++i){
            if(indegree[i] == 0)
                zeroDegree.offer(i);
        }
        
        while(!zeroDegree.isEmpty()){
            int size = zeroDegree.size();
            ++res;
            for(int i = 0; i < size; ++i){
                --n;
                int curr = zeroDegree.poll();
                if(!map.containsKey(curr)) continue;
                for(int course : map.get(curr)){
                    indegree[course]--;
                    if(indegree[course] == 0)
                        zeroDegree.offer(course);
                }
                map.remove(curr);
            }
        }
        
        return n == 0 ? res : -1;
    }
}