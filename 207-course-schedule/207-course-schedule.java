class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Create an array to track which courses have dependencies and how much
        //Create a hashset to track which courses do not have dependencies
        // If the set is empty, we return false because all courses have prereqs
        // Take a course with no dependencies and iterate through the first array we created and "complete" the course thereby reducing the number of prerequisite
        // If a course has no dependencies, we add it to our set.
        // If our course list is empty, we iterate through the first array and if a course still has dependecies we return false
        // Return true
        int[] indegree = new int[numCourses];
        Set<Integer> zeroDegree = new HashSet();
        for(int[] course : prerequisites){
            indegree[course[0]]++;
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(indegree[i] == 0)
                zeroDegree.add(i);
        }
        
        if(zeroDegree.isEmpty())
            return false;
        
        while(!zeroDegree.isEmpty()){
            Iterator<Integer> it = zeroDegree.iterator();
            int course = it.next();
            zeroDegree.remove(course);
            for(int[] pre : prerequisites){
                if(pre[1] == course){
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                    }
                }
            }
        }
        
        for(int course : indegree){
            if(course != 0)
                return false;
        }
        
        return true;
    }
}