class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Iterate through prerequisites to find track the number of prerequisites for each course and keep these counts in an array
        // Iterate through our created array and we'll assign any courses with no prequisites to a HashSet
        // If there are no courses with no prerequisites, we will return false because we can't even start completing courses`
        // Keep removing elements from out hashset until it's empty and iterate through the prerequisites array before "completing the current course" and decrementing the prerequisite counts in our tracker array
        // If the prerequisite count for a course reaches zero, we will add it to our set
        // At the end, we will iterate through our tracker array and if any element is not equal to zero, we will return false because we cannot complete the curriculum
        int[] inDegree = new int[numCourses];
        Set<Integer> zeroDegree = new HashSet();
        for(int[] pre: prerequisites){
            inDegree[pre[0]]++;
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(inDegree[i] == 0)
                zeroDegree.add(i);
        }
        
        if(zeroDegree.isEmpty())
            return false;
        
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
        
        for(int course : inDegree){
            if(course != 0)
                return false;
        }
        
        return true;
        
    }
}