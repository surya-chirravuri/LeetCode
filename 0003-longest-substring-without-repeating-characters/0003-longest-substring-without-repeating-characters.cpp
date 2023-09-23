class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<int>frequency(256,0);
        int start = 0, end = 0;
        int len = 0;
        for(end = 0; end < s.size(); end++) {
            frequency[s[end]]++;
            while(frequency[s[end]] > 1) {
                frequency[s[start++]]--;
            }
            len = max(len, end-start+1);
        }
        return len;
    }
};