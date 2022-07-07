class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites){
            inDegree[pre[0]]++;
        }
        
        HashSet<Integer> zeroDegree = new HashSet();
        for(int i = 0; i < inDegree.length; ++i){
            if(inDegree[i] == 0){
                zeroDegree.add(i);
            }
        }
        
        if(zeroDegree.isEmpty())
            return new int[]{};
        
        List<Integer> list = new ArrayList<>();
        
        while(!zeroDegree.isEmpty()){
            int curr = zeroDegree.iterator().next();
            zeroDegree.remove(curr);
            list.add(curr);
            for(int[] pre : prerequisites){
                if(pre[1] == curr){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                    } 
                }
            }
        }
        
        for(int i = 0; i < inDegree.length; ++i){
            if(inDegree[i] != 0)
                return new int[]{};
            
            inDegree[i] =  list.get(i);
        }
        
        return inDegree;
    }
}