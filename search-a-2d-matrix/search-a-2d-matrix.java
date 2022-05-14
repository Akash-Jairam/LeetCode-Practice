class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] row : matrix){
            if(row[row.length - 1] >= target)
                return binarySearch(row, target);
        }
        
        return false;
    }
    
    public boolean binarySearch(int[] row, int target){
        int lo = 0;
        int hi = row.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(row[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return row[lo] == target;
    }
}