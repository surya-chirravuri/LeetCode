class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        vector<int> frequency(256,0);
        int len = 0, start = 0, end = 0, count = 0;
        for(; end < s.size(); end++) {
           count += (frequency[s[end]] == 0);
           frequency[s[end]]++;
           while(count > k) {
               frequency[s[start]]--;
               if(frequency[s[start]] == 0) count--;
               start++;
           }
           len = max(len, end-start+1);
        }
        return len;
    }
};