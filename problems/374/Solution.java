// Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
// Memory Usage: 35.5 MB, less than 84.96% of Java online submissions for Guess Number Higher or Lower.
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
        int left = 0, right = n;
        int pick = (right-left)/2;
        int ret = 1;
        while ((ret = guess(pick)) != 0) {
            if (ret == -1) {
                if (pick == right) return left;
                right = pick;
            } else if (ret == 1) {
                if (pick == left) return right;
                left = pick;
            }
            pick = left + (right-left)/2;
        }
        return pick;
    }
}