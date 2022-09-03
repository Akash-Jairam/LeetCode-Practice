class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> curr = Arrays.asList(1,2,3,4,5,6,7,8,9);
        
        for(int i = 0; i < n - 1; ++i){
            List<Integer> curr2 = new ArrayList<>();
            for(int x : curr){
                int y = x % 10;
                if(y + k < 10){
                    curr2.add((x * 10) + y + k);
                }
                if(k > 0 && y - k >= 0){
                    curr2.add((x * 10) + y - k);
                }
            }
            curr = curr2;
        }
        int[] res = new int[curr.size()];
        for(int i = 0; i < res.length; ++i){
            res[i] = curr.get(i);
        }
        
        return res;
    }
}