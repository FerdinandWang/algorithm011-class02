//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1221 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        generate(0, 0, n, "");

        return result;
    }

    void generate(int left, int right, int n, String s) {
        if(left == n && right == n) {
            result.add(s);
            return ;
        }

        if(left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if(right < left) {
            generate(left, right + 1, n, s + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
