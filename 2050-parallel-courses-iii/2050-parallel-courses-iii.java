class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[n+1];
        int res = 0;
        
        for(int[] relation : relations){
            map.putIfAbsent(relation[0], new ArrayList<>());
            map.get(relation[0]).add(relation[1]);
            inDegree[relation[1]]++;
        }
        
        Queue<Integer> zeroDegree = new LinkedList<>();
        int minTime = Integer.MAX_VALUE;
        for(int i = 1; i < inDegree.length; ++i){
            if(inDegree[i] == 0){
                zeroDegree.offer(i);
                minTime = Math.min(minTime, time[i-1]);
            }
        }
        
        while(!zeroDegree.isEmpty()){
            int size = zeroDegree.size();
            int currMin = Integer.MAX_VALUE;
            res += minTime;
            for(int i = 0; i < size; ++i){
                int curr = zeroDegree.poll();
                if(time[curr-1] > minTime){
                    zeroDegree.offer(curr);
                    time[curr-1] -= minTime;
                    currMin = Math.min(currMin, time[curr-1]);
                } else{
                    if(!map.containsKey(curr)) continue;
                    for(int course : map.get(curr)){
                        inDegree[course]--;
                        if(inDegree[course] == 0){
                            zeroDegree.offer(course);
                            currMin = Math.min(currMin, time[course-1]);
                        }
                    }
                }
            }
            minTime = currMin;
        }
        
        return res;
    }
}