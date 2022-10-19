class Solution {
public:
    string frequencySort(string s) {
        vector<int> freq(256, 0);
        for(auto c: s) 
            freq[c]++;
        sort(s.begin(), s.end(), [&](const char &a , const char &b){
            return freq[a] != freq[b] ? freq[a] > freq[b] : a > b;
        });
        return s;
    }
};