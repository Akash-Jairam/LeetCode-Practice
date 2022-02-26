class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Create a queue that holds pairs of characters and integers
        // Put the characters a, b and c paired with their given counts into the queue
        // While the queue is not empty, check the last element of our stringbuilder and see if it is the element at the top of the queue, if it is, take the second element and add it to our string builder before putting both back while making sure to update the count
        // Else find the minimum of the count and 2, add that element to the queue  count timesand decrement it by the count before adding it back to the queue
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()));
        StringBuilder sb = new StringBuilder();
        
        if(a > 0)
            pq.add(new Pair<Character, Integer>('a', a));
        if(b > 0)
            pq.add(new Pair<Character, Integer>('b', b));
        if(c > 0)
            pq.add(new Pair<Character, Integer> ('c', c));
        
        while(!pq.isEmpty()){
            Pair<Character, Integer> firstPair = pq.poll();
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == firstPair.getKey()){
                if(pq.isEmpty())
                    return sb.toString();
                
                Pair<Character, Integer> secondPair = pq.poll();
                sb.append(secondPair.getKey());
                if(secondPair.getValue() - 1 > 0)
                    pq.add(new Pair<Character, Integer> (secondPair.getKey(), secondPair.getValue() -1));
                pq.add(firstPair);
            }else{
                int count = Math.min(firstPair.getValue(), 2);
                for(int i = 0; i < count; ++i){
                    sb.append(firstPair.getKey());
                }
                if(firstPair.getValue() - count > 0)
                    pq.add(new Pair<Character, Integer> (firstPair.getKey(), firstPair.getValue() - count));
            }
        }
        
        return sb.toString();
    }
}