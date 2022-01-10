class Solution {
    public int[] sortedSquares(int[] nums) {
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i] * nums[i]);
        }
        
        while(!pq.isEmpty()){
           nums[index] = pq.remove();
           index++;
        }
        
        return nums;
    }
}