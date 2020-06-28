//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import java.util.Collection;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //2.HashMap 建立差值与数组索引的关系
    public int[] twoSum(int[] nums, int target) {
        int[] resultNums = new int[2];
        Map<Integer, Integer> resultMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(resultMap.containsKey(nums[i])) {
                resultNums[0] = i;
                resultNums[1] = resultMap.get(nums[i]);
                return resultNums;
            }
            //建立差值与数组索引的对应关系
            resultMap.put(target - nums[i], i);
        }
        return resultNums;
    }
}
/*
1.暴力解法
public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int numsSize = nums.length;
        for(int i = 0; i < numsSize - 1; i++) {
            for(int j = i + 1; j < numsSize; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return new int[0];
    }
*/
//leetcode submit region end(Prohibit modification and deletion)
