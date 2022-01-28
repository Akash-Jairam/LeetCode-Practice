class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an array to track the number of prerequisite courses
        // Loop through that array to create a hashset with each course that does not have prerequisites
        // If no courses do not have prerequisites, return false
        //Iterate through each element of the hashset and Loop through the first array you created and decrement the occurence of courses before adding them to the hash set when their occurence reaches zero 
        // If the values of the first array are not equal to zero, we return false.
        // Else we return true
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
                if(pre[1] == course){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]] == 0)
                        zeroDegree.add(pre[0]);
                }
            }
        }
        
        for(int num : inDegree){
            if(num != 0)
                return false;
        }
        
        return true;
    }
}