class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer x, Integer y){
                 String xString = String.valueOf(x);
                 String yString = String.valueOf(y);
                 
                 xString = xString + "" + yString;
                 yString = yString + "" + xString;
                 
                return yString.compareTo(xString);
            }
        });
        
        for(int num : nums)
            pq.offer(num);
        
        while(!pq.isEmpty()){
            sb.append(String.valueOf(pq.poll()));
        }
        
        if(sb.charAt(0) == '0')
            return "0";
        
        return sb.toString();
    }
}