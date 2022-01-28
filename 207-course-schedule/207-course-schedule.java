class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int[] prereq: prerequisites){
            indegree[prereq[0]]++;
        }
        
        Set<Integer> zeroDegree = new HashSet();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                zeroDegree.add(i);
        }
        
        if(zeroDegree.isEmpty()){
            return false;
        }
        
        while(!zeroDegree.isEmpty()){
            Iterator<Integer> iter = zeroDegree.iterator();
            int course = iter.next();
            zeroDegree.remove(course);
            for(int[] pre : prerequisites){
                if(course == pre[1]){
                    indegree[pre[0]]--;
                    if(indegree[pre[0]] == 0)
                        zeroDegree.add(pre[0]);
                }
            }
        }
        
        for(int num : indegree){
            if(num != 0)
                return false;
        }
        
        return true;
    }
}