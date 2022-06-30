class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        for(int[] pre : prerequisites){
            inDegree[pre[0]]++;
        }
        HashSet<Integer> zeroDegree = new HashSet<>();
        
        for(int i = 0; i < inDegree.length; ++i){
            if(inDegree[i] == 0){
                zeroDegree.add(i);
                order.add(i);
            }
        }
        
        if(zeroDegree.isEmpty())
            return new int[]{};
        
        while(!zeroDegree.isEmpty()){
            Iterator<Integer> it = zeroDegree.iterator();
            int curr = it.next();
            zeroDegree.remove(curr);
            for(int[] pre : prerequisites){
                if(pre[1] == curr){
                    inDegree[pre[0]]--;
                    if(inDegree[pre[0]] == 0){
                        zeroDegree.add(pre[0]);
                        order.add(pre[0]);
                    }
                }
            }
        }
        
        for(int i = 0; i < inDegree.length; ++i){
            if(inDegree[i] != 0)
                return new int[]{};
            
            inDegree[i] = order.get(i);
        }
        
        return inDegree;
    }
}