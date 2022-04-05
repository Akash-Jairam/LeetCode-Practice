class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
                PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> (map.get(num1) - map.get(num2)));

        for(int key : map.keySet()){
            pq.offer(key);
            if(pq.size() > k)
                pq.poll();
        }
        int[] res = new int[k];
        int counter = 0;
        while(!pq.isEmpty()){
            res[counter] = pq.poll();
            ++counter;
        }
        
        return res;
    }
}