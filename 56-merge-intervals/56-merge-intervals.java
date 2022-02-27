class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the array
        // Create a pointer to the first array
        // Iterate through the array
        // If the last element of the first array is greater than the first element of the current array, update the last element of the "first array" to the greater last element of the two arrays
        // Else add the first array to the map and assign the second one as the first array
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);
        
        for(int[] interval : intervals){
            int[] next = interval;
            if(current[1] >= next[0]){
                current[1] = Math.max(current[1], interval[1]);
            } else {
                list.add(next);
                current = next;
            }
            
        }
        
        return list.toArray(new int[list.size()][]);
    }
}