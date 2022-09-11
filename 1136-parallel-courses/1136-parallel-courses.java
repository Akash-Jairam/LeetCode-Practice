class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // Create hashmap to keep track of courses and their dependencies and an array to keep track of the number of dependencies a course has
        // Iterate through map and add all the courses with no dependencies to the queue
        // Iterate through queue and 'complete' the courses in the queue in order to add the newly eligible courses to the queue
        // Decrement n and remove that current course from our map
        // ++semesters every time we iterate through the queue
        // If n == 0, return the num of semesters else return -1
        
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        int[] inDegree = new int[n+1];
        
        for(int[] relation : relations){
            map.putIfAbsent(relation[0], new ArrayList<>());
            map.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }
        
        Queue<Integer> zeroDegree = new LinkedList<>();
        for(int i = 1; i < inDegree.length; ++i){
            if(inDegree[i] == 0)
                zeroDegree.offer(i);
        }
        int numSems = 0;
        while(!zeroDegree.isEmpty()){
            int size = zeroDegree.size();
            ++numSems;
            for(int i = 0; i < size; ++i){
                int curr = zeroDegree.poll();
                --n;
                if(!map.containsKey(curr)) continue;
                for(int course : map.get(curr)){
                    inDegree[course]--;
                    if(inDegree[course] == 0)
                        zeroDegree.offer(course);
                }
                map.remove(curr);
            }
        }
        
        return n == 0 ? numSems : -1;
        
    }
}