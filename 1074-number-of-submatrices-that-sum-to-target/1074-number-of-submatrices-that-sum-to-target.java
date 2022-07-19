class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        
        for(int i = 0; i < m; ++i){
            for(int j = 1; j < n; ++j){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                counter.clear();
                counter.put(0,1);
                int curr = 0;
                for(int k = 0; k < m; ++k){
                    curr += matrix[k][j] - (i > 0 ? matrix[k][i-1] : 0);
                    res += counter.getOrDefault(curr - target, 0);
                    counter.put(curr, counter.getOrDefault(curr, 0) + 1);
                }
            }
        }
        
        return res;
    }
}