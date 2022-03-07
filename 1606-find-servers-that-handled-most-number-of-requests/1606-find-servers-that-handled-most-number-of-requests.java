class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Create a zero indexed array to track to k servers
        // Create a TreeSet to hold the available servers
        // Iterate through array and add every element to our treeset
        // Create a priority queue that holds arrays and keeps the lowest completion time at the top
        // Iterate through the arrival array 
        // Set the start time to the current index
        // Set the end time to the sum of the values at the current index for arrival and laod
        // Iterate through our priority queue and 'free' any server whose completion time is less than our index by removing it and adding the id to our treeset
        // Create an integer for the assignedServer and get the ceiling entry from the treeset
        // If the integer is null, get the first entry from the tree set
        // Add this integer and the completion time to the priority queue
        // Incremement the count of the index in our array corresponding to the server id 
        
        // Find the server id(s) with the highest count and add them to a list before returning it
        int[] servers = new int[k];
        PriorityQueue<int[]> unavailable = new PriorityQueue<>((x,y) -> (x[0] - y[0]));
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; ++i){
            available.add(i);
        }
        
        for(int i = 0; i < arrival.length; ++i){
            int startTime = arrival[i];
            int finishTime = startTime + load[i];
            
            while(!unavailable.isEmpty() && unavailable.peek()[0] <= startTime){
                available.add(unavailable.poll()[1]);
            }
            
            if(available.size() == 0)
                continue;
            
            Integer assignedServer = available.ceiling(i % k);
            if(assignedServer == null)
                assignedServer = available.first();
            
            
            unavailable.add(new int[] {finishTime, assignedServer});
            servers[assignedServer]++;
            available.remove(assignedServer);
            
        }
        
        return findHighest(servers);
    }
    
    public List<Integer> findHighest(int[] servers){
        int max = -1;
        int maxCount = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int count : servers){
            max = Math.max(max, count);
        }
        
        for(int i = 0; i < servers.length; ++i){
            if(servers[i] == max)
                result.add(i);
        }
        
        return result;
    }
}