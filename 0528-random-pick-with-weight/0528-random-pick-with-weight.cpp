class Solution {
public:
    vector<int> prefixWeights;
    Solution(vector<int>& w) {
        prefixWeights = w;
        for(int i = 1; i < prefixWeights.size(); i++) {
            prefixWeights[i] += prefixWeights[i-1];
        }
    }
    
    int binarySearch(int value) {
        int randomIndex = -1;
        int l = 0, r = prefixWeights.size()-1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(prefixWeights[mid] == value) {
                randomIndex = mid;
                break;
            }else if(prefixWeights[mid] > value){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return randomIndex == -1 ?(value <= prefixWeights[l] ? l : l + 1) : randomIndex;
    }
    
    int pickIndex() {
        int random = (rand() % prefixWeights.back());
        return binarySearch(random + 1);
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */