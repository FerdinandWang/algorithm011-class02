//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 829 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int mid = 0;
        while(l <= r) {
            mid = l + ((r - l) >> 1) ;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= target) {
                if(nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if(nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
