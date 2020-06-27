//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //双指针夹逼，注意此题解中的去重做法
    public List<List<Integer>> threeSum(int[] nums) {
        //特殊情况判定
        if(nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        //枚举第一个到倒数第三个
        for (int k = 0; k <  len - 2; k++) {
            if(nums[k] > 0) break; //大于零则不存在解
            if(k > 0 && nums[k] == nums[k-1]) continue; //去除重复解
            int i = k + 1, j = len - 1;
            while(i < j) {
                if (nums[i] + nums[j] > -nums[k]) {
                    while(i < j && nums[j] == nums[--j]);  //移动右指针，并去重复值
                } else if(nums[i] + nums[j] < -nums[k]) {
                    while(i < j && nums[i] == nums[++i]);  //移动左指针，并去重复值
                }
                else {
                    //得到一个解，并去重
                    resList.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return resList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
