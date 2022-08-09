class Solution {
    public boolean checkValid(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; ++i){
            int[] checkHori = new int[matrix.length+1];
            int[] checkVert = new int[matrix.length+1];
            for(int j = 0; j < matrix[0].length; ++j){
                int hori = matrix[i][j];
                int vert = matrix[j][i];
                if(checkHori[hori] > 0 || checkVert[vert] > 0)
                    return false;
                checkHori[hori]++;
                checkVert[vert]++;
                
            }
        }
        
        return true;
    }
}