class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 1)
            return s;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2) -> (p2.getValue() - p1.getValue()));
        
        for(Character key : map.keySet()){
            pq.offer(new Pair<Character, Integer>(key, map.get(key)));
        }
        
        StringBuilder sb = new StringBuilder(s.length());
        while(!pq.isEmpty()){
            Pair<Character, Integer> curr = pq.poll();
            for(int i = 0; i < curr.getValue(); ++i){
                sb.append(curr.getKey());
            }
        }
        return sb.toString();
    }
}