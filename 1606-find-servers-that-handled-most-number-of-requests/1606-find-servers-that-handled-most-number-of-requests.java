class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counter = new int[k];
        TreeSet<Integer> available = new TreeSet<Integer>();
        for(int num = 0; num < k; ++num){
            available.add(num);
        }
        
        Queue<int[]> busyServers = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for(int idx = 0; idx < arrival.length; ++idx){
            int currTime = arrival[idx];
            int endTime = currTime + load[idx];
            
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= currTime){
                int freedServer = busyServers.poll()[1];
                available.add(freedServer);
            }
            
            if(available.isEmpty())
                continue;
            
            Integer assignedServerId = available.ceiling(idx % k);
            if(assignedServerId == null)
                assignedServerId = available.first();
            
            counter[assignedServerId]++;
            available.remove(assignedServerId);
            busyServers.offer(new int[]{endTime, assignedServerId});  
        }
        
        return findMaxesInCounter(counter);
    }
    
    public List<Integer> findMaxesInCounter(int[] counter){
        int max = -1;
        List<Integer> result = new ArrayList<>();
        for(int count : counter){
            max = Math.max(max, count);
        }
        
        for(int i = 0; i < counter.length; ++i){
            if(counter[i] == max)
                result.add(i);
        }
        
        return result;
    }
}