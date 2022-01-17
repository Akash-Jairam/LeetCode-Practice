class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        
        for(int i = 1; i <= nums.length; i++){
            if(!pq.isEmpty()){
                if(pq.peek() != i){
                    list.add(i);
                }else{
                    while(!pq.isEmpty() && pq.peek() == i){
                        pq.remove();
                    }
                }
            } else{
                list.add(i);
            }
        }
        
        return list;
        
    }
}