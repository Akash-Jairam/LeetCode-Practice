class Solution {
    public int[] sumZero(int n) {
        if(n == 0)
            return new int[] {0};
        
        int num = -1;
        int[] res = new int[n];
        if(n % 2 == 1){
            res[0] = 0;
            fill(res, 1);
        }
        else{
            fill(res, 0);
        }
        
        return res;
    }
    
    public void fill(int[] nums, int index){
        int count = 0;
        int num = 1;
        
        for(int i = index; i < nums.length; ++i){
            num *= -1;
            nums[i] = num;
            ++count;
            if(count == 2){
                count = 0;
                ++num;
            }
        }
    }
}