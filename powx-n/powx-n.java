class Solution {
    public double myPow(double x, int n) {
        long num = n;
        if (num == 0) {
            return 1;
        }
        if( num < 0) {
            num = -1 * num;
            x = 1 / x;
        }
        double result = 1, multiply = 1;
        while(num > 0) {
            if((num & 1) == 1) {
                result *= x;
                num--;
            }
            x *= x;
            num /= 2;
        }

        return result;
    }
}