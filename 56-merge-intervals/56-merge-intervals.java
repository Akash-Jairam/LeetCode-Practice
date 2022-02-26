class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (l1, l2) -> Integer.compare(l1[0],l2[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        for(int[] interval : intervals){
            if(current[1] >= interval[0] ){
                current[1] = Math.max(current[1], interval[1]);
            }else{
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}