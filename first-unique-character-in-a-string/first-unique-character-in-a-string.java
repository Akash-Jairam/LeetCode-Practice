class Solution {
    public int firstUniqChar(String s) {
        if(s.length() <=1)
            return 0;
        int[] map = new int[128];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        int uniqueChar = -1;
        for(char c : s.toCharArray()){
            map[c]++;
        }
        
        for(int i = 0; i < map.length; ++i){
            if(map[i] == 1){
                    pq.add(s.indexOf(Character.toString((char)i)));
            }
        }
        
        
        return pq.isEmpty() ? -1 : pq.remove();
    }
}