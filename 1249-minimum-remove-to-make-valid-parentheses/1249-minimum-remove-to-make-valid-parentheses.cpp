class Solution {
public:
    string minRemoveToMakeValid(string s) {
        stack<int>st;
        string res = "";
        for(int i = 0; i < s.size(); i ++) {
            char append = s[i];
            if(s[i] == '(') {
                st.push(i);
            }
            else if(s[i] == ')') {
                if(!st.empty()) st.pop();
                else append = '-';
            }
            res += append;
        }
        int len = st.size();
        while(!st.empty()){
            res[st.top()] = '-';
            st.pop();
        }
        string output = "";
        for(auto letter: res) {
            if( letter == '-')
                continue;
            output += letter;
        }
        
        return output;
    }
};