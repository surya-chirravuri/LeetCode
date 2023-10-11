class Solution {
public:
    bool isNumber(char c) {
        return c >= '0' && c <= '9';
    }
    
    pair<int,int> getNumber(string abbr, int index) {
        // if(abbr[index] >= '0' && abbr[index] <= '9') return {-1, index};
        if(abbr[index] == '0') return {-1, -1};
        int num = 0;
        while(index < abbr.size() && isNumber(abbr[index])) {
            num = num * 10 + (abbr[index++] - '0');
        }
        return {num, index};
    }
    
    bool validWordAbbreviation(string word, string abbr) {
        int i = 0, j = 0;
        while(i < word.size() && j < abbr.size()) {
            auto [num, next] = getNumber(abbr, j);
            if(next == -1) return false;
            // cout<<i<<" "<<j<<" "<<num<<" "<<next<<endl;
            int increment = 0;
            while( increment < num && i < word.size()) {
                increment++, i++;
            }
            if( i == word.size()) {
                // cout<<"a"<<" "<<abbr[j];
                if(next != abbr.size() || increment != num)
                    return false;
            }
            if(next == j ) {
                if(word[i] != abbr[j]) {
                    // cout<<"b";
                    return false;
                }
                i++, j++;
            } else {
                j = next;
            }
        }
        return i == word.size() && j == abbr.size();
    }
};
