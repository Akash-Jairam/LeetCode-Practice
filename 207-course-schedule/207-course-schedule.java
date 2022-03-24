class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create a map to track which courses have depdencies where the key is the course and the value is the dependency
        // Crease a hashset to track which courses have no dependencies
        // Iterate through the map and add any course which has no dependency. If the hashset is empty, return false/
        // Iterate through the hashset and the given array and 'complete' the dependencies for the associated course
        // Iterate through the map and if any value is still > 0 return false
        // return true otherwhise
        int[] indegree = new int[numCourses];
        HashSet<Integer> zeroDep = new HashSet();
        
        for(int[] pre : prerequisites){
           indegree[pre[0]]++;
        }
        
        for(int i = 0; i < indegree.length; ++i){
            if(indegree[i] == 0)
                zeroDep.add(i);
        }
        
        if(zeroDep.isEmpty())
            return false;
        
        while(!zeroDep.isEmpty()){
            Iterator<Integer> it = zeroDep.iterator();
            Integer curr = it.next();
            zeroDep.remove(curr);
            for(int[] pre : prerequisites){
                if(pre[1] == curr){
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0){
                        zeroDep.add(pre[0]);
                    }
                }
            }
        }
        
        for(int count : indegree){
            if(count != 0)
                return false;
        }
        
        return true;
    }
}