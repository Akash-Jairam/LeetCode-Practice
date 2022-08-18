class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] list = new int[arr.length+1];
        
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : map.keySet()){
            int count = map.get(num);
            list[count] += 1;
        }
        
        int steps = 0, res = 0;
        
        for(int i = arr.length; i >= 0; --i){
            int curr = list[i];
            while(curr > 0){
                steps += i;
                ++res;
                if(steps >= arr.length / 2)
                    return res;
                --curr;
            }
        }
        
        return arr.length;
    }
}