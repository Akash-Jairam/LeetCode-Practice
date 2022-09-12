class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0, score = 0, start = 0, end = tokens.length - 1;
        
        while(start <= end){
            if(power >= tokens[start]){
                power -= tokens[start];
                ++start;
                ++score;
                res = Math.max(res, score);
            } else if(score > 0){
                --score; 
                power += tokens[end];
                --end;
            } else{
                break;
            }
        }
        
        return res;
    }
}