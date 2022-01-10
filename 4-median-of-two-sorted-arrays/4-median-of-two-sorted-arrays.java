class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(y,x));
        for(int num : nums1){
            pq.add(num);
        }
        
        for(int num: nums2){
            pq.add(num);
        }
        Integer[] arr1 = new Integer[pq.size()];
        Integer[] array = pq.toArray(arr1);
        Arrays.sort(array);
        int medianIndex;
        if(array.length % 2 != 0){
            return (double)array[array.length /2];
        }else {
            int sum = (array[array.length/2] + array[(array.length/2)-1]);
            return (double) sum /2 ;
        }
    }
}