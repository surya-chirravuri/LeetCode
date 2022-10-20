class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var index = hashMapOf<Int,Int>()
        for(i in 0..nums.size - 1) {
            if(index[target - nums[i]] != null) {
                return intArrayOf(i,index[target - nums[i]]!!)
            }
            index[nums[i]] = i
        }
        return intArrayOf(-1,-1)
    }
}