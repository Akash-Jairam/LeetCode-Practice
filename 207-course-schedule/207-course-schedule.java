class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an array of numCourses size and iterate through prerequisites to keep track of the courses that have prerequisites/dependencies/edges
        // Create a hashset and iterate through the created array and add the courses that have no prerequisistes or dependencies to the hashmap
        // If the hashset is empty, all the courses have dependencies so we return false
        // Else take each element from the hashset and iterate through the created array and remove the edges/completing the dependencies. Add any element which has no more dependencies
        // to our set
        // Iterate through the created array and if any element is not equal to zero, we return false
        int[] inDegree = new int[numCourses];
        Set<Integer> zeroDegree = new HashSet();
        
        for(int[] pre : prerequisites){
            inDegree[pre[0]]++;
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(inDegree[i] == 0){
                zeroDegree.add(i);
            }
        }
        
        if(zeroDegree.isEmpty()){
            return false;
        }
        
        while(!zeroDegree.isEmpty()){
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            zeroDegree.remove(course);
            for(int[] pre : prerequisites){
                if(course == pre[1]){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]] == 0)
                        zeroDegree.add(pre[0]);
                }
            }
        }
        
        for(int count : inDegree){
            if(count != 0)
                return false;
        }
        
        return true;
    }
}