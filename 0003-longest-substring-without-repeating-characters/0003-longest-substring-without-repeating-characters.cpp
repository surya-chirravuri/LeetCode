class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char,int> frequency;
        int start = 0, end = 0;
        int len = 0;
        // cout<<frequency.size();
        for(end = 0; end < s.size(); end++) {
            frequency[s[end]]++;
            // if(frequency[s[end]] == 1) {
            //     continue;
            // }
            // cout<<frequency.size()<<" "<<start<<" "<<end<<endl;
            while(frequency[s[end]] > 1) {
                // if(frequency[s[start]]-- == 0) {
                //     frequency.erase(s[start]);
                // }
                frequency[s[start++]]--;
               // start++;
            }
            len = max(len, end-start+1);
        }
        return len;
    }
};