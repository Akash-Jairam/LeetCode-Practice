class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort our array in ascending order for the tallest people according to whether they have a person in front of them
        // Everything else, will be sorted in descending order according to their height
        // Create a linkedlist and add people from the sorted array using the second value in each array as an insertion point
        // Convert our linkedlist to an array and return it
        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] nums1, int[] nums2){
                if(nums1[0] == nums2[0])
                    return nums1[1] - nums2[1];
                else
                    return nums2[0] - nums1[0];
            }
        };
        Arrays.sort(people, comp);
        List<int[]> list = new LinkedList<>();
        
        for(int[] person : people){
            list.add(person[1], person);
        }
        
        return list.toArray(new int[people.length][2]);
    }
}