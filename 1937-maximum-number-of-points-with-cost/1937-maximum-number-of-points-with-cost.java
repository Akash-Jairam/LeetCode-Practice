class Solution {
    public long maxPoints(int[][] points) {
        // Each score is based on the result of the previous row
        // Since the first row has no previous row, we can use dynamic programming to find the optimal result for the first row
        // We can then use the first row to calculate the optimal result for the other rows
        // We will create an array to track the previous row
        // We will then create two arrays to track the best choice when we are coming from the left and when we are coming from the right respectively
        // The first index of the left array will be equal to the value at the first index in our previous row
        // Similarly, the last index of the right array will be equal to the value at the last index in our previous row
        // The following indices in both arrays will be the greater of the previous index -1 (we need to factor in the column difference) and the value of the current index in the previous row
        // Now that we have the optimal scores, we can create our current array and assign to it, the value at the next row plus the greater of the values at the immediate left and immediate right 
        // When we finish setting the values in our current array, we will set the previous array to our current array
        // At the end of our program, we will iterate through the previous array and simply choose the max value since it will store the results of all the optimal traversals
        int rowLength = points[0].length;
        int columnLength = points.length;
        long maxPoints = -1;
        // Create our array to track previous values and assign the values in the first row
        long[] pre = new long[rowLength];
        for(int i = 0; i < rowLength; ++i){
            pre[i] = points[0][i];
        }
        
        for(int i = 0; i < columnLength-1; ++i){
            long[] leftBest = new long[rowLength];
            long[] rightBest = new long[rowLength];
            long[] currentRow = new long[rowLength];
            
            // At the first index from the left, we don't have anything to compare against so we use the first number. The same will apply for the last index from the right
            leftBest[0] = pre[0];
            rightBest[rowLength - 1] = pre[rowLength - 1];
            
            for(int j = 1; j < rowLength; ++j){
                leftBest[j] = Math.max(leftBest[j-1] - 1, pre[j]);
            }
            
            for(int j = rowLength-2; j >= 0; --j){
                rightBest[j] = Math.max(rightBest[j + 1] - 1, pre[j]);
            }
            
            // Now that our best possible choices have been calculated, we need check the current row and make a choice
            
            for(int j = 0; j < rowLength; ++j){
                currentRow[j] = points[i + 1][j] + Math.max(leftBest[j], rightBest[j]);
            }
            pre = currentRow;
        }
        
        for(int i = 0; i < rowLength; ++i){
            maxPoints = Math.max(maxPoints, pre[i]);
        }
        
        return maxPoints;
    }
}