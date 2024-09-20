class Solution {
    public int mySqrt(int x) {
        if( x < 2) return x;
        int l = 0, r = x / 2;
        int sqrt = -1, mid;
        while(l <= r) {
            mid = l + (r - l) / 2;
            long square = (long) mid * mid;
            if(square > x) {
                r = mid - 1;
            } else if(square < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return r;
    }
}//86974964