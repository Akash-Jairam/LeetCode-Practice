class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // We first want to correctly find the correct locations of the tallest people
        // We do this by sorting the array using a custom comparator which sorts the tallest people in ascending order based on if there is someone in front of them and sorts everything else in descending order
        // This way, the tallest people are placed first and everyone else is placed around them
        // Next, we will create a linked list and insert each subarray based on how many people they can see before them
        // Convert that linkedlist to an array and return it
        Comparator<int[]> comp = new Comparator<>(){
            @Override
            public int compare(int[] nums1, int nums2[]){
                if(nums1[0] == nums2[0])
                    return nums1[1] - nums2[1];
                else
                    return nums2[0] - nums1[0];
            }
        };
        Arrays.sort(people, comp);
        
        List<int[]> list = new LinkedList<>();
        
        for(int[] arr : people){
            list.add(arr[1], arr);
        }
        
        return list.toArray(new int[people.length][2]);
    }
}