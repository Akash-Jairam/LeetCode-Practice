class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
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