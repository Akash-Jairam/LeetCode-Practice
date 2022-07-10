class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length-1;
        int i = a > 0 ? nums.length - 1 : 0;
        

        while(start <= end){
            int startNum = calculate(nums[start], a, b, c);
            int endNum = calculate(nums[end], a, b, c);
            
            if(a > 0){
                if(startNum > endNum){
                    res[i] = startNum;
                    ++start;
                } else {
                    res[i] = endNum;
                    --end;
                }
                --i;
            } else {
                if(startNum < endNum){
                    res[i] = startNum;
                    ++start;
                } else {
                    res[i] = endNum;
                    --end;
                }
                ++i;
            }
        }
        
        return res;
    }
    
    public int calculate(int num, int a, int b, int c){
        return (a * num * num) + (b * num) + c;
    }
}