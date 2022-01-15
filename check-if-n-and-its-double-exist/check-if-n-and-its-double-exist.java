class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr.length <= 1)
            return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i] * 2)){
                return true;
            } else if (arr[i] % 2 == 0 && map.containsKey(arr[i]/2)){
                return true;
            } else
                map.put(arr[i], arr[i]);
        }
        
        return false;
    }
}