class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 1;
        int top = 0; 
        int left = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        List<Integer> list = new ArrayList<>();
        while(top <= bottom && left <= right){
            if(dir == 1){
                for(int i = left; i <= right; ++i){
                    list.add(matrix[top][i]);
                }
                ++top;
                ++dir;
            } else if(dir == 2){
                for(int i = top; i <= bottom; ++i){
                    list.add(matrix[i][right]);
                }
                --right;
                ++dir;
            } else if(dir == 3){
                for(int i = right; i >= left; --i){
                    list.add(matrix[bottom][i]);
                }
                --bottom;
                ++dir;
            } else {
                for(int i = bottom; i >= top; --i){
                    list.add(matrix[i][left]);
                }
                ++left;
                dir = 1;
            }
        }
        
       return list;
    }
}