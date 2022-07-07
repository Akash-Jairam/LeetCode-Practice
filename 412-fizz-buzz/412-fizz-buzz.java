class Solution {
    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; ++i){
            boolean divideBy3 = i % 3 == 0;
            boolean divideBy5 = i % 5 == 0;
            if(divideBy3 && divideBy5)
                res.add(fizz + buzz);
            else if(divideBy3)
                res.add(fizz);
            else if(divideBy5)
                res.add(buzz);
            else
                res.add(String.valueOf(i));
        }
        
        return res;
    }
}