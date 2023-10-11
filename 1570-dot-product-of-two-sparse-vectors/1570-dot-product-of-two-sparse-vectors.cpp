class SparseVector {
public:
    unordered_map<int,int> sparse;
    SparseVector(vector<int> &nums) {
       for(int i = 0; i < nums.size(); i++) {
           if(nums[i]) {
               sparse[i] = nums[i];
           }
       }
    }
    
    // Return the dotProduct of two sparse vectors
    int dotProduct(SparseVector& vec) {
        int product = 0;
        auto vec2 = vec.sparse;
        for(auto p: sparse){
            product += (vec2.count(p.first)) ? (vec2[p.first] * p.second) : 0;
        }
        return product;
    }
};

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1(nums1);
// SparseVector v2(nums2);
// int ans = v1.dotProduct(v2);