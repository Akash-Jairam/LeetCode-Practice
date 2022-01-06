class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length == 1){
            return result;
        }
        
        
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length;j++ ){
                if(numbers[i] + numbers[j] == target){
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        return result;
    }
}