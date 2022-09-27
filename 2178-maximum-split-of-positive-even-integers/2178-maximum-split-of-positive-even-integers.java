class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        
        if(finalSum % 2 == 0){
            Long num = 2L;
            while(num <= finalSum){
                finalSum -= num;
                res.add(num);
                num += 2;
            }
        } else{
            return res;
        }
        
        res.add(finalSum + res.remove(res.size() - 1));
        return res;
    }
}