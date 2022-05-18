class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2) -> p2.getValue() - p1.getValue());
        
        if(a > 0)
            pq.offer(new Pair<Character, Integer>('a', a));
        
        if(b > 0)
            pq.offer(new Pair<Character, Integer>('b', b));
        
        if(c > 0)
            pq.offer(new Pair<Character, Integer>('c', c));
        
        StringBuilder sb = new StringBuilder(a + b + c);
        
        while(!pq.isEmpty()){
            Pair<Character, Integer> first = pq.poll();
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == first.getKey()){
                if(pq.isEmpty())
                    return sb.toString();
                
                Pair<Character, Integer> second = pq.poll();
                sb.append(second.getKey());
                if(second.getValue() - 1 > 0)
                    pq.offer(new Pair<Character, Integer>(second.getKey(), second.getValue() - 1));
                pq.offer(first);
            } else{
                int val = Math.min(first.getValue(), 2);
                for(int i = 0; i < val; ++i)
                    sb.append(first.getKey());
                if(first.getValue() - val > 0)
                    pq.offer(new Pair<Character, Integer>(first.getKey(), first.getValue() - val));
            }
                
        }
        return sb.toString();
    }
}