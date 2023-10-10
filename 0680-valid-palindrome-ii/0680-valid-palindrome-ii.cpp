class Solution {
public:
    bool checkPalindrome(string s, int i , int j) {
        while( i < j) {
            if(s[i++] != s[j--])
                return false;
        }
        return true;
    }
    
    bool validPalindrome(string s) {
        int i = 0, j = s.size()-1;
        int count = 0;
        while (i < j) {
            if(s[i] != s[j]) {
                break;
            } else  {
                i++, j--;
            }
        }
        return i != j ? checkPalindrome(s, i+1, j) || checkPalindrome(s, i, j-1) : true;
    }
};