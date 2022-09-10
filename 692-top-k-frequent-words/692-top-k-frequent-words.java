class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new WordComparator());
        for(Map.Entry<String, Integer> e : map.entrySet()){
            pq.offer(e);
            if(pq.size() > k)
                pq.poll();
        }
        
        while(!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
    
    class WordComparator implements Comparator<Map.Entry<String, Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> p1, Map.Entry<String, Integer> p2){
            if(p1.getValue() == p2.getValue()){
                return p2.getKey().compareTo(p1.getKey());
            }
            
            return p1.getValue() - p2.getValue();
        }
    }
}