class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((num1, num2) -> (num2 - num1));
        PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((num1, num2) -> (num1 - num2));
        
        for(int num : nums){
            maxQueue.offer(num);
            minQueue.offer(num);
            if(maxQueue.size() > 3)
                maxQueue.poll();
            
            if(minQueue.size() > 2)
                minQueue.poll();
            
            if(maxQueue.size() > 3)
                maxQueue.poll();
        }
        
        int max = maxQueue.poll();
        int res1 = max;
        while(!maxQueue.isEmpty()){
            max = maxQueue.poll();
            res1 *= max;
        }
        
        while(!minQueue.isEmpty()){
            max *= minQueue.poll();
        }
        return Math.max(res1 , max);
    }
}