/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int upperLimit = n;
        int lowerLimit = 1;
        int result = lowerLimit + ((upperLimit - lowerLimit) / 2);
        int feedback = guess(result);
        while(feedback != 0 && lowerLimit < upperLimit){
            if(feedback == -1){
                upperLimit = result-1;
            }else{
                lowerLimit = result+1;
            }
            result = lowerLimit + ((upperLimit - lowerLimit) / 2);
            feedback = guess(result);
        }
        
        return result;
    }
}