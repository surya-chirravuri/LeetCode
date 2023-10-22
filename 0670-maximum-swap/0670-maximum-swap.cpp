class Solution {
public:   
    int maximumSwap(int num) {
        string digits = to_string(num);
        int n = digits.size();
        vector<int> index(10, -1);
        for(int i = 0; i < digits.size(); i++) {
            index[digits[i] - '0'] = i;
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 9; j > digits[i] - '0'; j--) {
                if(index[j] > i ){
                    swap(digits[i], digits[index[j]]);
                    return stoi(digits);
                }
            }
        }
        return num;
    }
};