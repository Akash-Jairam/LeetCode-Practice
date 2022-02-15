class Solution {
    public long maxPoints(int[][] points) {
        int rowLength = points[0].length;
        int columnLength = points.length;
        long ans = -1;
        
        // Create an array and initialize it with the values of the first array
        long[] pre = new long[rowLength] ;
        
        for(int i = 0; i < rowLength; ++i){
            pre[i] = points[0][i];
        }
        
        for(int i = 0; i < columnLength-1; ++i){
            long[] left = new long[rowLength];
            long[] right = new long[rowLength];
            long[] curr = new long[rowLength];
            
            left[0] = pre[0];
            right[rowLength-1] = pre[rowLength-1];
            for(int j = 1; j < rowLength; ++j){
                left[j] = Math.max(left[j-1] -1, pre[j]);
            }
            
            for(int j = rowLength-2; j >=0; --j){
                right[j] = Math.max(right[j+1] -1, pre[j]);
            }
            
            for(int j = 0; j < rowLength; ++j){
                curr[j] = Math.max(left[j], right[j]) + points[i+1][j];
            }
            pre = curr;
        }
        
        for(int i = 0; i < rowLength; ++i){
            ans = Math.max(ans, pre[i]);
        }
        return ans;
    }
}