class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        if(arr.length == k){
            for(int num : arr) res.add(num);
            return res;
        }
        
        int left = 0, right = arr.length;
        int mid = 0;
        
        while(left < right){
            mid = left + (right - left) / 2;
            
            if(arr[mid] >= x){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        
        left -= 1;
        right = left + 1;
        
        while(right - left - 1 < k){
            if(left == -1){
                ++right;
                continue;
            }
            if(right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                left -= 1;
            } else{
                right += 1;
            }
        }
        
        for(int i = left + 1; i < right; ++i){
            res.add(arr[i]);
        }
        return res;
    }
}