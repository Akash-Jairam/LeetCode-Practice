class Solution {
    public long maxPoints(int[][] points) {
        long[] pre = new long[points[0].length];
        int rowLength = points[0].length;
        int columnLength = points.length;
        
        for(int i = 0; i < points[0].length; ++i){
            pre[i] = points[0][i];
        }
        
        for(int i = 0; i < points.length-1; ++i){
            long[] leftMax = new long[rowLength];
            long[] rightMax = new long[rowLength];
            long[] current = new long[rowLength];
            leftMax[0] = pre[0];
            rightMax[rowLength-1] = pre[rowLength-1];
            
            for(int j = 1; j < rowLength; ++j){
                leftMax[j] = Math.max(leftMax[j-1] - 1, pre[j]);
            }
            
            for(int j = rowLength-2; j >= 0; --j){
                rightMax[j] = Math.max(rightMax[j + 1] - 1, pre[j]);
            }
            
            // Now that our best possible choices have been calculated, we need check the current row and make a choice
            
            for(int j = 0; j < rowLength; ++j){
                current[j] = points[i + 1][j] + Math.max(leftMax[j], rightMax[j]);
            }
            pre = current;
        }
        
        long result = 0;
        for(long num : pre){
            result = Math.max(result, num);
        }
        
        return result;
    }
}