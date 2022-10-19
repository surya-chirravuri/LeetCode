class Solution {
public:
    string frequencySort(string s) {
        int freq[256] = {};
        for(auto c: s) 
            freq[c]++;
        sort(s.begin(), s.end(), [&](char a , char b){
            return freq[a] != freq[b] ? freq[a] > freq[b] : a > b;
        });
        return s;
    }
};