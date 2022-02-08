class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length <=1)
            return people;
        Comparator<int[]> comp = new Comparator<>(){
            @Override
            public int compare(int[] nums1, int nums2[]){
                return nums1[0] == nums2[0] ? nums1[1] - nums2[1] : nums2[0] - nums1[0];
            }
        };
        Arrays.sort(people, comp);
        List<int[]> list = new LinkedList<>();
        for(int[] arr: people){
            list.add(arr[1], arr);
        }
        return list.toArray(new int[2][people.length]);
    }
}