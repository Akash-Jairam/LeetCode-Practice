class Solution {
    public boolean isPalindrome(int x) {
        int copy = x;
        int count = 0;
        int numberToCompare = 0;
        if(x < 0){
            return false;
        } else if(x < 10){
            return true;
        } else if(x == Integer.MAX_VALUE)
            return false;
        
        List<Integer> arr = new ArrayList<>();
        while(copy > 0){
            arr.add(copy%10);
            copy /= 10;
            count++;
        }
        
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == 0){
                count--;
                continue;
            }
            else
                numberToCompare += (arr.get(i) * Math.pow(10, count-1));
            count--;
        }
        
        if(numberToCompare - x == 0)
            return true;
        else
            return false;
        
        
        
    }
}