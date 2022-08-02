class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return -1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m-1][n-1];
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = count(matrix, m, n, mid);
            
            if(count < k){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        
        return left;
    }
    
    public int count(int[][] matrix, int m, int n, int mid){
        int count = 0;
        int j = n - 1;
        
        for(int i = 0; i < m; ++i){
            while(j >= 0 && matrix[i][j] > mid) j--;
            count += j + 1;
        }
        
        return count;
    }
}