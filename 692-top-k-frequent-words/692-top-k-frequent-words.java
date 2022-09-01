class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((p1, p2) ->
        p1.getValue() == p2.getValue() ? p2.getKey().compareTo(p1.getKey()) : p1.getValue() - p2.getValue());
        
        for(String key : map.keySet()){
            pq.offer(new Pair<>(key, map.get(key)));
            if(pq.size() > k)
                pq.poll();
        }
        
        List<String> res = new ArrayList<>();
        
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}